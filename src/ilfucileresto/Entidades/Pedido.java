package ilfucileresto.Entidades;
// El Sebas: El rockanroll no morirá jamás ♡♡♡♡♡♡♡ 

import java.time.LocalDateTime;

public class Pedido {

    private int idPedido;
    private Mesa mesa;
    private Empleado empleado;
    private LocalDateTime fechaHora;
    private double importe;
    private int estado;
    private boolean pago;

    public Pedido(int idPedido, Mesa mesa, Empleado empleado, LocalDateTime fechaHora, double importe, int estado, boolean pago) {
        this.idPedido = idPedido;
        this.mesa = mesa;
        this.empleado = empleado;
        this.fechaHora = fechaHora;
        this.importe = importe;
        this.estado = estado;
        this.pago = pago;
    }

    public Pedido(Mesa mesa, Empleado empleado, LocalDateTime fechaHora, double importe, int estado, boolean pago) {
        this.mesa = mesa;
        this.empleado = empleado;
        this.fechaHora = fechaHora;
        this.importe = importe;
        this.estado = estado;
        this.pago = pago;
    }

    public Pedido() {
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        return "Pedido: " + idPedido;
    }

}
