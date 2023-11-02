package ilfucileresto.AccesoADatos;
// El Sebas: El rockanroll no morirá jamás ♡♡♡♡♡♡♡ 

import ilfucileresto.Entidades.DetallePedido;
import ilfucileresto.Entidades.Pedido;
import ilfucileresto.Entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class DetallePedidoData {

    private Connection con = null;
    private PedidoData peD = new PedidoData();
    private ProductoData prD = new ProductoData();

    public DetallePedidoData() {
        con = Conexion.getConnection();
    }

    public void agregarDetallePedido(Pedido pedido, Producto producto, int cant) {
        String sql = "INSERT INTO detallePedido VALUES(?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getIdPedido());
            ps.setInt(2, producto.getIdProducto());
            ps.setInt(3, cant);
            int fila = ps.executeUpdate();
            if (fila > 0) {
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detallePedido " + ex.getMessage());
        }
    }

    public List<DetallePedido> listarDetallePedidosPorEmpleado(int idEmpleado) {
        List<DetallePedido> detallesPedidos = new ArrayList<>();
        try {
            String sql = "SELECT detallePedido.* FROM detallepedido\n"
                    + "JOIN pedido\n"
                    + "ON detallepedido.idPedido=pedido.idPedido\n"
                    + "WHERE pedido.idEmpleado=?\n"
                    + "ORDER BY detallepedido.idPedido desc;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEmpleado);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DetallePedido dp = new DetallePedido();
                Producto pr = prD.buscarProducto(rs.getInt("idProducto"));
                Pedido ped = peD.buscarPedido(rs.getInt("idPedido"));
                dp.setPedido(ped);
                dp.setProducto(pr);
                dp.setCantidad(rs.getInt("Cantidad"));
                detallesPedidos.add(dp);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DetallePedidoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return detallesPedidos;
    }

    public List<DetallePedido> listarDetallePedidosPorEmpleadoPreciosHora(int idEmpleado) {
        List<DetallePedido> detallesPedidos = new ArrayList<>();
        try {
            String sql = "Select detallePedido.* from detallepedido\n"
                    + "JOIN pedido\n"
                    + "ON detallepedido.idPedido=pedido.idPedido\n"
                    + "WHERE pedido.idEmpleado=?\n"
                    + "GROUP BY detallepedido.idPedido  \n"
                    + "ORDER BY `detallepedido`.`idPedido` DESC;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEmpleado);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DetallePedido dp = new DetallePedido();
                Pedido ped = peD.buscarPedido(rs.getInt("idPedido"));
                dp.setPedido(ped);
                Producto pr = prD.buscarProducto(rs.getInt("idProducto"));
                dp.setProducto(pr);
                dp.setCantidad(rs.getInt("Cantidad"));
                detallesPedidos.add(dp);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DetallePedidoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return detallesPedidos;
    }

    public List<DetallePedido> listarDetallePedidosPorId(int idPedido) {
        List<DetallePedido> detallesPedidos = new ArrayList<>();
        try {
            String sql = "Select detallePedido.* from detallepedido\n"
                    + "JOIN pedido\n"
                    + "ON detallepedido.idPedido=pedido.idPedido\n"
                    + "WHERE pedido.idPedido=?\n"
                    + "order by detallepedido.idPedido desc;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPedido);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DetallePedido dp = new DetallePedido();
                Producto pr = prD.buscarProducto(rs.getInt("idProducto"));
                Pedido ped = peD.buscarPedido(rs.getInt("idPedido"));
                dp.setPedido(ped);
                dp.setProducto(pr);
                dp.setCantidad(rs.getInt("Cantidad"));
                detallesPedidos.add(dp);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DetallePedidoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return detallesPedidos;
    }

    public void eliminarDetallePedido(Pedido pedido) {
        String sql = "DELETE FROM detallePedido WHERE idPedido=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getIdPedido());
            int fila = ps.executeUpdate();
            if (fila > 0) {
//                JOptionPane.showMessageDialog(null, "Detalle Eliminado.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detallePedido " + ex.getMessage());
        }
    }

    public void actualizarDetallePedido(Pedido pedido, Producto producto, int cantidad) {
        String sql = "UPDATE detallePedido SET cantidad=?,idProducto=? WHERE idPedido=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cantidad);
            ps.setInt(2, producto.getIdProducto());
            ps.setInt(3, pedido.getIdPedido());
            int fila = ps.executeUpdate();
            if (fila > 0) {
                JOptionPane.showMessageDialog(null, "Detalle actualizado.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detallePedido " + ex.getMessage());
        }
    }
//    SELECT p.nombreProducto,d.cantidad,p.precioUnitario, p.precioUnitario*d.cantidad as subtotal 
//    FROM `producto` p join detallepedido d on p.idProducto=d.idProducto WHERE d.idProducto=2
//    and d.idPedido=2 

    public double calcularSubtotal(Producto producto, int cantidad) {
        double subtotal = 0;
        String sql = "SELECT precioUnitario FROM producto WHERE idProducto=?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, producto.getIdProducto());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                subtotal = rs.getDouble("precioUnitario");
                subtotal *= cantidad;
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detallePedido " + ex.getMessage());
        }
        return subtotal;
    }

    public double calcularTotal(Pedido pedido) {
        String sql = "SELECT SUM(p.precioUnitario*d.cantidad) AS total"
                + "  FROM `producto` p "
                + "      JOIN detallepedido d ON p.idProducto=d.idProducto"
                + " WHERE d.idPedido=?";
        PreparedStatement ps = null;
        double total = 0;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getIdPedido());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getDouble("total");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla detallePedido " + ex.getMessage());
        }
        return total;
    }
}
