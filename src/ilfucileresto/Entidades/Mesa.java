package ilfucileresto.Entidades;
// El Sebas: El rockanroll no morirá jamás ♡♡♡♡♡♡♡ 
public class Mesa {

    private int idMesa;
    private int estadoMesa;
    private int capacidad;

    public Mesa(int idMesa, int estadoMesa, int capacidad) {
        this.idMesa = idMesa;
        this.estadoMesa = estadoMesa;
        this.capacidad = capacidad;
    }

    public Mesa(int estadoMesa, int capacidad) {
        this.estadoMesa = estadoMesa;
        this.capacidad = capacidad;
    }

    public Mesa() {
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getEstadoMesa() {
        return estadoMesa;
    }

    public void setEstadoMesa(int estadoMesa) {
        this.estadoMesa = estadoMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return  "Mesa Nº" + idMesa + "- Capacidad: " + capacidad;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.idMesa;
        hash = 71 * hash + this.estadoMesa;
        hash = 71 * hash + this.capacidad;
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
        final Mesa other = (Mesa) obj;
        if (this.idMesa != other.idMesa) {
            return false;
        }
        if (this.estadoMesa != other.estadoMesa) {
            return false;
        }
        if (this.capacidad != other.capacidad) {
            return false;
        }
        return true;
    }
}
