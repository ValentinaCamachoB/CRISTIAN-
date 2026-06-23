package com.example.strategy.service;

import com.example.strategy.entity.ResultadoPago;

public interface MetodoPago {

    /**
     * Procesa el pago segun la estrategia concreta.
     * @param monto cantidad de dinero a pagar
     * @return informacion sobre el resultado del pago
     */
    ResultadoPago procesarPago(double monto);

    String getNombre();
}

