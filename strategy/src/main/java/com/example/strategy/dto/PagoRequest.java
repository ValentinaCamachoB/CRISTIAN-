package com.example.strategy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class PagoRequest {

    @NotBlank(message = "Debe indicar el metodo de pago (tarjeta, paypal, pse o nequi)")
    private String metodo;

    @Positive(message = "El monto debe ser mayor a 0")
    private double monto;

    public PagoRequest() {
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}

