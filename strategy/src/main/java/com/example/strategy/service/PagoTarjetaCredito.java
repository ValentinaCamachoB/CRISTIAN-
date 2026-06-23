package com.example.strategy.service;

import com.example.strategy.entity.ResultadoPago;
import org.springframework.stereotype.Component;

@Component
public class PagoTarjetaCredito implements MetodoPago {

    @Override
    public ResultadoPago procesarPago(double monto) {

        System.out.println(">> Procesando pago con TARJETA DE CREDITO por $" + monto);

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

