package com.example.strategy.service;

import com.example.strategy.entity.ResultadoPago;

/**
 * Esta es la INTERFAZ STRATEGY.
 *
 * Define el contrato que deben cumplir todos los metodos de pago.
 * Cada clase que implemente esta interfaz sera una "estrategia" diferente
 * (Tarjeta de credito, PayPal, PSE, Nequi, etc).
 *
 * Gracias a esto, el resto del sistema no necesita saber cual metodo
 * de pago se esta usando: solo llama al metodo procesarPago() y listo.
 */
public interface MetodoPago {

    /**
     * Procesa el pago segun la estrategia concreta.
     * @param monto cantidad de dinero a pagar
     * @return informacion sobre el resultado del pago
     */
    ResultadoPago procesarPago(double monto);

    /**
     * Devuelve el nombre del metodo de pago (ej: "tarjeta", "paypal").
     * Sirve para identificar la estrategia desde el controlador.
     */
    String getNombre();
}

