package com.example.strategy.service;

import com.example.strategy.entity.ResultadoPago;
import org.springframework.stereotype.Component;

@Component
public class PagoPSE implements MetodoPago {

    @Override
    public ResultadoPago procesarPago(double monto) {
        System.out.println(">> Procesando pago con PSE por $" + monto);

        double comision = 1500.0;
        double total = monto + comision;

        String mensaje = "Pago aprobado por PSE (debito bancario). " +
                         "Comision aplicada: $" + comision +
                         ". Total cobrado: $" + total;

        return new ResultadoPago(true, mensaje, getNombre(), total);
    }

    @Override
    public String getNombre() {
        return "pse";
    }
}
