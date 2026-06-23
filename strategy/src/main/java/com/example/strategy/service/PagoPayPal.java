package com.example.strategy.service;

import com.example.strategy.entity.ResultadoPago;
import org.springframework.stereotype.Component;

/**
 * ESTRATEGIA CONCRETA 2: Pago con PayPal.
 *
 * Otra forma de pagar, totalmente independiente de las demas.
 * Si un dia PayPal cambia su API o desaparece, solo se modifica
 * esta clase, sin tocar el resto del codigo. Eso es lo bueno del patron.
 */
@Component
public class PagoPayPal implements MetodoPago {

    @Override
    public ResultadoPago procesarPago(double monto) {
        System.out.println(">> Procesando pago con PAYPAL por $" + monto);

        // PayPal cobra una comision fija de $2 + 2.9% del monto
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

