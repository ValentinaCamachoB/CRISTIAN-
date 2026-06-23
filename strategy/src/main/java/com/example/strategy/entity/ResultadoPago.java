package com.example.strategy.entity;

/**
 * Clase que representa el resultado de un pago.
 * Aunque no estamos usando base de datos, la pongo en el paquete
 * entity porque es la que representa el "objeto del negocio".
 */
public class ResultadoPago {

    private boolean exitoso;
    private String mensaje;
    private String metodoUsado;
    private double totalCobrado;

    public ResultadoPago(boolean exitoso, String mensaje, String metodoUsado, double totalCobrado) {
        this.exitoso = exitoso;
        this.mensaje = mensaje;
        this.metodoUsado = metodoUsado;
        this.totalCobrado = totalCobrado;
    }

    // Getters y setters (necesarios para que Spring serialice a JSON)
    public boolean isExitoso() {
        return exitoso;
    }

    public void setExitoso(boolean exitoso) {
        this.exitoso = exitoso;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMetodoUsado() {
        return metodoUsado;
    }

    public void setMetodoUsado(String metodoUsado) {
        this.metodoUsado = metodoUsado;
    }

    public double getTotalCobrado() {
        return totalCobrado;
    }

    public void setTotalCobrado(double totalCobrado) {
        this.totalCobrado = totalCobrado;
    }
}
