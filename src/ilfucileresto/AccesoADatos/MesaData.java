package ilfucileresto.AccesoADatos;
// El Sebas: El rockanroll no morirá jamás ♡♡♡♡♡♡♡ 

import ilfucileresto.Entidades.Mesa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MesaData {

    private Connection con = null;

    public MesaData() {
        con = Conexion.getConnection();
    }

    public void guardarMesa(Mesa mesa) {
        try {
            String sql = "INSERT INTO mesa(idMesa,estadoMesa,capacidad) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,mesa.getIdMesa());
            ps.setInt(2, mesa.getEstadoMesa());
            ps.setInt(3, mesa.getCapacidad());
            int exito = ps.executeUpdate();
            //No es auto incremental porque el idMesa es el NroMesa
            //ResultSet rs = ps.getGeneratedKeys();
            if (exito ==1) {
                //mesa.setIdMesa(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Mesa añadida con exito ");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mesa " + ex.getMessage());
        }
    }
    
    public Mesa buscarMesa(int id) {

        Mesa mesa = null;
        String sql = "SELECT idMesa,estadoMesa,capacidad FROM mesa WHERE idMesa = ?";

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                mesa = new Mesa();
                mesa.setIdMesa(id);
                mesa.setEstadoMesa(rs.getInt("estadoMesa"));
                mesa.setCapacidad(rs.getInt("capacidad"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe la mesa.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mesa " + ex.getMessage());
        }
        return mesa;
    }
    
    public void modificarMesa(Mesa mesa) {
        String sql = "UPDATE mesa SET estadoMesa=?, capacidad=? WHERE idMesa = ?";
        PreparedStatement ps = null;
        int exito = 0;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, mesa.getEstadoMesa());
            ps.setInt(2, mesa.getCapacidad());
            ps.setInt(3, mesa.getIdMesa());
            exito = ps.executeUpdate();
            
            if (exito == 1) {
                //JOptionPane.showMessageDialog(null, "Modificado exitosamente.");
            }
        } catch (SQLException ex) {
            if (exito == 0) {
                JOptionPane.showMessageDialog(null, "La mesa no existe.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mesa " + ex.getMessage());
            }
        }
    }
    
    public List<Mesa> listarMesas(boolean filtroEstado) {
        List<Mesa> mesas = new ArrayList<>();
        try {
            String sql="";
            
            if (filtroEstado){
                sql = "SELECT * FROM mesa WHERE estadoMesa = 1";  
            }else{
                sql = "SELECT * FROM mesa";
            }
            
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mesa mesa = new Mesa();
                mesa.setIdMesa(rs.getInt("idMesa"));
                mesa.setEstadoMesa(rs.getInt("estadoMesa"));
                mesa.setCapacidad(rs.getInt("capacidad"));
                mesas.add(mesa);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mesa." + ex.getMessage());
        }
        return mesas;
    }
    
    public List<Mesa> listarMesasDesc() {
        List<Mesa> mesas = new ArrayList<>();
        try {
            String sql="SELECT * FROM mesa ORDER BY idMesa DESC";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mesa mesa = new Mesa();
                mesa.setIdMesa(rs.getInt("idMesa"));
                mesa.setEstadoMesa(rs.getInt("estadoMesa"));
                mesa.setCapacidad(rs.getInt("capacidad"));
                mesas.add(mesa);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mesa." + ex.getMessage());
        }
        return mesas;
    }
    
}
