package ilfucileresto.Entidades;
// El Sebas: El rockanroll no morirá jamás ♡♡♡♡♡♡♡ 

import java.util.Objects;


public class Empleado {

    private int idEmpleado;
    private String apellido, nombre, DNI, puesto, user, password;
    private boolean estado;

    public Empleado(int idEmpleado, String apellido, String nombre, String DNI, String puesto, String user, String password, boolean estado) {
        this.idEmpleado = idEmpleado;
        this.apellido = apellido;
        this.nombre = nombre;
        this.DNI = DNI;
        this.puesto = puesto;
        this.user = user;
        this.password = password;
        this.estado = estado;
    }

    public Empleado(String apellido, String nombre, String DNI, String puesto, String user, String password, boolean estado) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.DNI = DNI;
        this.puesto = puesto;
        this.user = user;
        this.password = password;
        this.estado = estado;

    }

    public Empleado(int idEmpleado, String apellido, String nombre, String DNI, String puesto, boolean estado) {
        this.idEmpleado = idEmpleado;
        this.apellido = apellido;
        this.nombre = nombre;
        this.DNI = DNI;
        this.puesto = puesto;
        this.estado = estado;
    }

    
    public Empleado() {
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    } 

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.idEmpleado;
        hash = 67 * hash + Objects.hashCode(this.apellido);
        hash = 67 * hash + Objects.hashCode(this.nombre);
        hash = 67 * hash + Objects.hashCode(this.DNI);
        hash = 67 * hash + Objects.hashCode(this.puesto);
        hash = 67 * hash + (this.estado ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        if (this.idEmpleado != other.idEmpleado) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.DNI, other.DNI)) {
            return false;
        }
        if (!Objects.equals(this.puesto, other.puesto)) {
            return false;
        }
      
        return true;
    }

    
    
    @Override
    public String toString() {
        return idEmpleado + " - " + apellido + " " + nombre + " - " + DNI;
    }
}
