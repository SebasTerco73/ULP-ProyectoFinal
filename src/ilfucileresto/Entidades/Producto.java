package ilfucileresto.Entidades;
// El Sebas: El rockanroll no morirá jamás ♡♡♡♡♡♡♡ 

public class Producto {

    private int idProducto;
    private String nombreProducto;
    private double precioUnitario;
    private int stock;
    private boolean estado;

    public Producto(int idProducto, String nombreProducto, double precioUnitario, int stock, boolean estado) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
        this.estado = estado;
    }

    public Producto(String nombreProducto, double precioUnitario, int stock, boolean estado) {
        this.nombreProducto = nombreProducto;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
        this.estado = estado;
    }

    public Producto() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        String disponible;
        if (estado) {
            disponible = "Disponible";
        } else {
            disponible = "No disponible";
        }
        
        return idProducto + " - " + nombreProducto + " $" + precioUnitario + " / Stock: " + stock + " - " + disponible;
    }

}
