package com.example.strategy.service;

import com.example.strategy.entity.ResultadoPago;
import org.springframework.stereotype.Component;

@Component
public class PagoPayPal implements MetodoPago {

    @Override
    public ResultadoPago procesarPago(double monto) {
        System.out.println(">> Procesando pago con PAYPAL por $" + monto);

        double comision = 2.0 + (monto * 0.029);
        double total = monto + comision;

        String mensaje = "Pago aprobado por PayPal. " +
                         "Comision aplicada: $" + comision +
                         ". Total cobrado: $" + total;

        return new ResultadoPago(true, mensaje, getNombre(), total);
    }

    @Override
    public String getNombre() {
        return "paypal";
    }
}

