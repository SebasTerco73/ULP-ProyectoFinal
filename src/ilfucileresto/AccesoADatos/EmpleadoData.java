package ilfucileresto.AccesoADatos;
// El Sebas: El rockanroll no morirá jamás ♡♡♡♡♡♡♡ 

import ilfucileresto.Entidades.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EmpleadoData {

    private Connection con = null;

    public EmpleadoData() {
        con = Conexion.getConnection();
    }

    public void guardarEmpleado(Empleado empleado) {
        try {
            String sql = "INSERT INTO empleado(apellido,nombre,DNI,puesto,user,password,estado) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, empleado.getApellido());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.getDNI());
            ps.setString(4, empleado.getPuesto());
            ps.setString(5, empleado.getUser());
            ps.setString(6, empleado.getPassword());
            ps.setBoolean(7, empleado.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                empleado.setIdEmpleado(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Empleado añadido con exito ");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla empleado " + ex.getMessage());
        }
    }

    public Empleado buscarEmpleado(int id) {

        Empleado empleado = null;
        String sql = "SELECT idEmpleado,apellido,nombre,DNI,puesto,user,password,estado FROM empleado WHERE idEmpleado = ?";

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                empleado = new Empleado();
                empleado.setIdEmpleado(id);
                empleado.setApellido(rs.getString("apellido"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setDNI(rs.getString("DNI"));
                empleado.setPuesto(rs.getString("puesto"));
                empleado.setUser(rs.getString("user"));
                empleado.setPassword(rs.getString("password"));
                empleado.setEstado(rs.getBoolean("estado"));

            } else {
                JOptionPane.showMessageDialog(null, "No existe el empleado.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla empleado " + ex.getMessage());
        }
        return empleado;
    }

    public Empleado buscarEmpleadoPorDni(String dni) {

        Empleado empleado = null;
        String sql = "SELECT idEmpleado,apellido,nombre,DNI,puesto,user,password,estado FROM empleado WHERE DNI = ?";

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt("idEmpleado"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setDNI(dni);
                empleado.setPuesto(rs.getString("puesto"));
                empleado.setUser(rs.getString("user"));
                empleado.setPassword(rs.getString("password"));
                empleado.setEstado(rs.getBoolean("estado"));

            } else {
                JOptionPane.showMessageDialog(null, "No existe el empleado.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla empleado " + ex.getMessage());
        }
        return empleado;
    }

    public void modificarEmpleado(Empleado empleado) {
        String sql = "UPDATE empleado SET apellido=?,nombre=?,DNI=?,puesto=?,estado=? WHERE idempleado = ?";
        PreparedStatement ps = null;
        int exito = 0;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, empleado.getApellido());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.getDNI());
            ps.setString(4, empleado.getPuesto());
            ps.setBoolean(5, empleado.isEstado());
            ps.setInt(6, empleado.getIdEmpleado());
            exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado exitosamente.");
            }
        } catch (SQLException ex) {
            if (exito == 0) {
                JOptionPane.showMessageDialog(null, "El empleado no existe.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla empleado " + ex.getMessage());
            }
        }
    }

    public Empleado buscarEmpleadoPorUser(String usuario, String contrasenia) {
        Empleado empleado = null;
        String sql = "SELECT idEmpleado,apellido,nombre,DNI,puesto,user,password,estado FROM empleado WHERE user = ? AND password = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contrasenia);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt("idEmpleado"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setDNI(rs.getString("DNI"));
                empleado.setPuesto(rs.getString("puesto"));
                empleado.setUser(usuario);
                empleado.setPassword(contrasenia);
                empleado.setEstado(rs.getBoolean("estado"));

            } else {
                //JOptionPane.showMessageDialog(null, "No existe el empleado.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla empleado " + ex.getMessage());
        }
        return empleado;
    }

    public void modificarLogin(Empleado empleado) {
        String sql = "UPDATE empleado SET password=? WHERE idempleado = ?";
        PreparedStatement ps = null;
        int exito = 0;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, empleado.getPassword());
            ps.setInt(2, empleado.getIdEmpleado());
            exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado exitosamente.");
            }
        } catch (SQLException ex) {
            if (exito == 0) {
                JOptionPane.showMessageDialog(null, "El empleado no existe.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla empleado " + ex.getMessage());
            }
        }
    }

    public List<Empleado> listarEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        try {
            String sql = "SELECT * FROM empleado";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt("idEmpleado"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setDNI(rs.getString("DNI"));
                empleado.setPuesto(rs.getString("puesto"));
                empleado.setEstado(rs.getBoolean("estado"));
                empleados.add(empleado);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla empleado." + ex.getMessage());
        }
        return empleados;
    }

}
