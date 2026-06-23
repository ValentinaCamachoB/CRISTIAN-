package com.example.strategy.service;

import com.example.strategy.entity.ResultadoPago;
import org.springframework.stereotype.Component;

@Component
public class PagoNequi implements MetodoPago {

    @Override
    public ResultadoPago procesarPago(double monto) {
        System.out.println(">> Procesando pago con NEQUI por $" + monto);

        double comision = 0.0;
        double total = monto + comision ;

        String mensaje = "Pago aprobado por Nequi. " +
                         "Sin comision. Total cobrado: $" + total;

        return new ResultadoPago(true, mensaje, getNombre(), total);
    }

    @Override
    public String getNombre() {
        return "nequi";
    }
}

