package com.example.strategy.service;

import com.example.strategy.entity.ResultadoPago;
import org.springframework.stereotype.Component;

/**
 * ESTRATEGIA CONCRETA 4: Pago con Nequi.
 *
 * Esta clase la agregue al final para demostrar lo mas importante
 * del patron: para añadir un nuevo metodo de pago, NO toque nada
 * de las otras clases. Solo cree esta y listo.
 *
 * Esto cumple el "Principio Abierto/Cerrado": el codigo esta
 * ABIERTO a la extension pero CERRADO a la modificacion.
 */
@Component
public class PagoNequi implements MetodoPago {

    @Override
    public ResultadoPago procesarPago(double monto) {
        System.out.println(">> Procesando pago con NEQUI por $" + monto);

        // Nequi normalmente no cobra comision al usuario
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

