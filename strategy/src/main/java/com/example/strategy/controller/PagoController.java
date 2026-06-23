package com.example.strategy.controller;

import com.example.strategy.dto.PagoRequest;
import com.example.strategy.entity.ResultadoPago;
import com.example.strategy.service.PagoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que expone los endpoints de pagos.
 *
 * Aqui llegan las peticiones HTTP y se las paso al PagoService,
 * que es el que sabe que hacer con cada metodo.
 */
@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final PagoService pagoService;

    // Inyeccion por constructor (es la forma recomendada en Spring)
    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    /**
     * Endpoint principal: procesa un pago.
     *
     * POST http://localhost:8080/api/pagos
     * Body (JSON):
     * {
     *   "metodo": "paypal",
     *   "monto": 50000
     * }
     */
    @PostMapping
    public ResponseEntity<ResultadoPago> realizarPago(@Valid @RequestBody PagoRequest request) {
        ResultadoPago resultado = pagoService.realizarPago(
            request.getMetodo(),
            request.getMonto()
        );

        if (resultado.isExitoso()) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.badRequest().body(resultado);
        }
    }

    /**
     * Endpoint informativo: lista los metodos de pago disponibles.
     *
     * GET http://localhost:8080/api/pagos/metodos
     */
    @GetMapping("/metodos")
    public ResponseEntity<List<String>> listarMetodos() {
        return ResponseEntity.ok(pagoService.listarMetodosDisponibles());
    }

    /**
     * Endpoint de bienvenida para verificar que la app funciona.
     *
     * GET http://localhost:8080/api/pagos/info
     */
    @GetMapping("/info")
    public ResponseEntity<String> info() {
        return ResponseEntity.ok(
            "API de pagos - Ejemplo del patron Strategy. " +
            "Use POST /api/pagos para realizar un pago, " +
            "o GET /api/pagos/metodos para ver las opciones."
        );
    }
}

