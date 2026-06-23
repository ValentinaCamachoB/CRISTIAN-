package com.example.strategy.service;

import com.example.strategy.entity.ResultadoPago;
import org.springframework.stereotype.Component;

/**
 * ESTRATEGIA CONCRETA 1: Pago con Tarjeta de Credito.
 *
 * Esta clase es UNA de las posibles formas de pagar.
 * Implementa la interfaz MetodoPago y define su propia logica.
 */
@Component
public class PagoTarjetaCredito implements MetodoPago {

    @Override
    public ResultadoPago procesarPago(double monto) {
        // Aqui iria la logica real para conectarse a la pasarela de pagos.
        // Para este ejemplo solo simulamos el cobro.
        System.out.println(">> Procesando pago con TARJETA DE CREDITO por $" + monto);

        // Las tarjetas de credito normalmente cobran una comision del 3%
        double comision = monto * 0.03;
        double total = monto + comision;

        String mensaje = "Pago aprobado con tarjeta de credito. " +
                         "Comision aplicada: $" + comision +
                         ". Total cobrado: $" + total;

        return new ResultadoPago(true, mensaje, getNombre(), total);
    }

    @Override
    public String getNombre() {
        return "tarjeta";
    }
}

