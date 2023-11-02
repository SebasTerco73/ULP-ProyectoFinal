package ilfucileresto.AccesoADatos;
// El Sebas: El rockanroll no morirá jamás ♡♡♡♡♡♡♡ 

import ilfucileresto.Entidades.Empleado;
import ilfucileresto.Entidades.Mesa;
import ilfucileresto.Entidades.Pedido;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PedidoData {

    private Connection con = null;
    private MesaData mesaData = new MesaData();
    private EmpleadoData empleadoData = new EmpleadoData();

    public PedidoData() {
        con = Conexion.getConnection();

    }

    public void guardarPedido(Pedido pedido) {
        try {
            String sql = "INSERT INTO pedido(idMesa,idEmpleado,fechaHora,importe,estado,pago) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pedido.getMesa().getIdMesa());
            ps.setInt(2, pedido.getEmpleado().getIdEmpleado());
            java.sql.Timestamp fecha = java.sql.Timestamp.valueOf(pedido.getFechaHora());
            ps.setTimestamp(3, fecha);
            ps.setDouble(4, pedido.getImporte());
            ps.setInt(5, pedido.getEstado());
            ps.setBoolean(6, pedido.isPago());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pedido.setIdPedido(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Pedido añadido con exito ");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido " + ex.getMessage());
        }
    }

    public Pedido buscarPedido(int id) {

        Pedido pedido = null;
        String sql = "SELECT idMesa,idEmpleado,fechaHora,importe,estado,pago FROM pedido WHERE idPedido = ?";

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pedido = new Pedido();
                pedido.setIdPedido(id);
                Mesa mesa = mesaData.buscarMesa(rs.getInt("idMesa"));
                Empleado empleado = empleadoData.buscarEmpleado(rs.getInt("idEmpleado"));
                pedido.setMesa(mesa);
                pedido.setEmpleado(empleado);
                Timestamp fecha = rs.getTimestamp("fechaHora");
                pedido.setFechaHora(fecha.toLocalDateTime());
                pedido.setImporte(rs.getDouble("importe"));
                pedido.setEstado(rs.getInt("estado"));
                pedido.setPago(rs.getBoolean("pago"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el pedido.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido " + ex.getMessage());
        }

        return pedido;
    }
    
     public List<Pedido> buscarPedidoAbiertoPorMesa(Mesa mesa) {

        Pedido pedido = null;
        String sql = "SELECT idPedido,idEmpleado,fechaHora,importe,estado,pago FROM pedido WHERE idMesa = ? AND pago=0 AND estado=1";

        PreparedStatement ps = null;
        List <Pedido> pedidos = new ArrayList<>();
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, mesa.getIdMesa());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                Empleado empleado = empleadoData.buscarEmpleado(rs.getInt("idEmpleado"));
                pedido.setMesa(mesa);
                pedido.setEmpleado(empleado);
                Timestamp fecha = rs.getTimestamp("fechaHora");
                pedido.setFechaHora(fecha.toLocalDateTime());
                pedido.setImporte(rs.getDouble("importe"));
                pedido.setEstado(rs.getInt("estado"));
                pedido.setPago(rs.getBoolean("pago"));
                pedidos.add(pedido);
            }
//                JOptionPane.showMessageDialog(null, "No existe el pedido.");

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido " + ex.getMessage());
        }

        return pedidos;
    }

    public void modificarPedido(Pedido pedido) {

        String sql = "UPDATE pedido SET idMesa=?, idEmpleado=?, fechaHora=?, importe=?, estado=?, pago=? WHERE idPedido = ?";
        PreparedStatement ps = null;
        int exito = 0;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getMesa().getIdMesa());
            ps.setInt(2, pedido.getEmpleado().getIdEmpleado());
            java.sql.Timestamp fecha = java.sql.Timestamp.valueOf(pedido.getFechaHora());
            ps.setTimestamp(3, fecha);
            ps.setDouble(4, pedido.getImporte());
            ps.setInt(5, pedido.getEstado());
            ps.setBoolean(6, pedido.isPago());
            ps.setInt(7, pedido.getIdPedido());

            exito = ps.executeUpdate();
            if (exito == 1) {
//                JOptionPane.showMessageDialog(null, "Modificado exitosamente.");
            }
        } catch (SQLException ex) {
            if (exito == 0) {
//                JOptionPane.showMessageDialog(null, "El pedido no existe.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido " + ex.getMessage());
            }
        }
    }

    public List<Pedido> listarPedidosPorFecha(LocalDate fecha) {
        List<Pedido> pedidos = new ArrayList<>();
        try {
            String sql = "SELECT idPedido FROM pedido WHERE DATE(fechaHora) = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido pedido = buscarPedido(rs.getInt("idPedido"));
                pedidos.add(pedido);
            }
            ps.close();
        } catch (SQLException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido." + ex.getMessage());
        }
        return pedidos;
    }

    public List<Pedido> listarPedidosPorMesero(Empleado mesero, LocalDate fech) {

        //Ver parametro opcional para fecha...
        List<Pedido> pedidos = new ArrayList<>();
        try {
            String sql = "SELECT idPedido FROM pedido WHERE idEmpleado = ? ";
            if (fech != null) {
                sql += " AND DATE(fechaHora)= ? ";
            }
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, mesero.getIdEmpleado());
            if (fech != null) {
                ps.setDate(2, java.sql.Date.valueOf(fech));
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido pedido = this.buscarPedido(rs.getInt("idPedido"));
                pedidos.add(pedido);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido." + ex.getMessage());
        }
        return pedidos;
    }

    public List<Pedido> listarPedidosPorMeseroMesa(Empleado mesero, Mesa mesa) {

        //Ver parametro opcional para fecha...
        List<Pedido> pedidos = new ArrayList<>();
        try {
            String sql = "SELECT idPedido FROM pedido WHERE idEmpleado = ? AND idMesa=? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, mesero.getIdEmpleado());
            ps.setInt(2, mesa.getIdMesa());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido pedido = this.buscarPedido(rs.getInt("idPedido"));
                pedidos.add(pedido);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido." + ex.getMessage());
        }
        return pedidos;
    }

    public List<Pedido> listarPedidosPorMesaPorHora(Mesa mesa, LocalDate dia, LocalTime horaDesde, LocalTime horaHasta) {
        List<Pedido> pedidos = new ArrayList<>();

        try {
            String sql = "SELECT idPedido FROM pedido WHERE idMesa=? AND Date(fechaHora)=? AND Time(fechaHora) BETWEEN Time(?) AND Time(?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, mesa.getIdMesa());
            ps.setDate(2, java.sql.Date.valueOf(dia));
            ps.setTime(3, java.sql.Time.valueOf(horaDesde));
            ps.setTime(4, java.sql.Time.valueOf(horaHasta));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido pedido = buscarPedido(rs.getInt("idPedido"));
                pedidos.add(pedido);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido." + ex.getMessage());
        }
        return pedidos;
    }
    
    public List<Pedido> listarPedidosPorHora(LocalDate dia, LocalTime horaDesde, LocalTime horaHasta) {
        List<Pedido> pedidos = new ArrayList<>();

        try {
            String sql = "SELECT idPedido FROM pedido WHERE Date(fechaHora)=? AND Time(fechaHora) BETWEEN Time(?) AND Time(?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(dia));
            ps.setTime(2, java.sql.Time.valueOf(horaDesde));
            ps.setTime(3, java.sql.Time.valueOf(horaHasta));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido pedido = buscarPedido(rs.getInt("idPedido"));
                pedidos.add(pedido);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido." + ex.getMessage());
        }
        return pedidos;
    }


    public double calcularIngresosPorFecha(LocalDate fecha) {
        double total = -1;
        try {
            String sql = "SELECT sum(importe) as total FROM pedido WHERE DATE(fechaHora) = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();
            total = rs.getInt("total");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido." + ex.getMessage());
        }
        return total;
    }

}
