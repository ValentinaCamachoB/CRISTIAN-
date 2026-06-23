package com.example.strategy.service;

import com.example.strategy.entity.ResultadoPago;
import org.springframework.stereotype.Component;

/**
 * ESTRATEGIA CONCRETA 3: Pago con PSE (debito bancario en Colombia).
 *
 * PSE es muy comun en Colombia, asi que tiene sentido tenerlo como
 * una opcion mas. La gracia del patron Strategy es que agregar esta
 * clase NO daña nada de lo que ya estaba funcionando.
 */
@Component
public class PagoPSE implements MetodoPago {

    @Override
    public ResultadoPago procesarPago(double monto) {
        System.out.println(">> Procesando pago con PSE por $" + monto);

        // PSE cobra una comision baja, fija de $1500 COP aprox
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
