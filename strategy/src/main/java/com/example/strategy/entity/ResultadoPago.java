package com.example.strategy.entity;

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
