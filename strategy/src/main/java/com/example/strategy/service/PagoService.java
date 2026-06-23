package com.example.strategy.service;

import com.example.strategy.entity.ResultadoPago;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PagoService {

    private final Map<String, MetodoPago> estrategias = new HashMap<>();

    public PagoService(List<MetodoPago> metodosDisponibles) {
        for (MetodoPago metodo : metodosDisponibles) {
            estrategias.put(metodo.getNombre().toLowerCase(), metodo);
        }
        System.out.println("Metodos de pago cargados: " + estrategias.keySet());
    }

    public ResultadoPago realizarPago(String nombreMetodo, double monto) {
        if (nombreMetodo == null) {
            return new ResultadoPago(false, "El metodo de pago no puede ser nulo", "ninguno", 0);
        }

        MetodoPago estrategia = estrategias.get(nombreMetodo.toLowerCase());

        if (estrategia == null) {
            String disponibles = String.join(", ", estrategias.keySet());
            return new ResultadoPago(
                false,
                "Metodo de pago no soportado: " + nombreMetodo +
                ". Opciones disponibles: " + disponibles,
                "ninguno",
                0
            );
        }

        return estrategia.procesarPago(monto);
    }

    public List<String> listarMetodosDisponibles() {
        return List.copyOf(estrategias.keySet());
    }
}

