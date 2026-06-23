package com.example.strategy.service;

import com.example.strategy.entity.ResultadoPago;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Esta es la clase CONTEXTO del patron Strategy.
 *
 * Su trabajo es:
 *  1. Conocer todas las estrategias disponibles (los metodos de pago).
 *  2. Recibir el nombre del metodo que el usuario eligio.
 *  3. Buscar la estrategia correspondiente y delegarle el trabajo.
 *
 * Lo bueno es que esta clase NO sabe COMO funciona cada metodo de pago,
 * solo sabe que todos cumplen la interfaz MetodoPago. Asi se mantiene
 * desacoplado de los detalles.
 */
@Service
public class PagoService {

    // Spring va a inyectar AUTOMATICAMENTE todos los componentes que
    // implementen la interfaz MetodoPago. Por eso no tengo que registrarlos
    // a mano.
    private final Map<String, MetodoPago> estrategias = new HashMap<>();

    /**
     * Spring me pasa todas las implementaciones de MetodoPago.
     * Las guardo en un mapa para buscarlas rapido por nombre.
     */
    public PagoService(List<MetodoPago> metodosDisponibles) {
        for (MetodoPago metodo : metodosDisponibles) {
            estrategias.put(metodo.getNombre().toLowerCase(), metodo);
        }
        System.out.println("Metodos de pago cargados: " + estrategias.keySet());
    }

    /**
     * Aqui ocurre la "magia" del patron Strategy:
     * el cliente solo dice QUE metodo quiere, no COMO funciona.
     */
    public ResultadoPago realizarPago(String nombreMetodo, double monto) {
        if (nombreMetodo == null) {
            return new ResultadoPago(false, "El metodo de pago no puede ser nulo", "ninguno", 0);
        }

        // Busco la estrategia por su nombre
        MetodoPago estrategia = estrategias.get(nombreMetodo.toLowerCase());

        // Si no existe, devuelvo un error claro
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

        // Delego el trabajo a la estrategia concreta
        return estrategia.procesarPago(monto);
    }

    /**
     * Devuelve la lista de nombres de metodos disponibles.
     * Util para el endpoint que muestra las opciones al usuario.
     */
    public List<String> listarMetodosDisponibles() {
        return List.copyOf(estrategias.keySet());
    }
}

