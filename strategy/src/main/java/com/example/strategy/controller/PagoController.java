package com.example.strategy.controller;

import com.example.strategy.dto.PagoRequest;
import com.example.strategy.entity.ResultadoPago;
import com.example.strategy.service.PagoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

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

    @GetMapping("/metodos")
    public ResponseEntity<List<String>> listarMetodos() {
        return ResponseEntity.ok(pagoService.listarMetodosDisponibles());
    }

    @GetMapping("/info")
    public ResponseEntity<String> info() {
        return ResponseEntity.ok(
            "API de pagos - Ejemplo del patron Strategy. " +
            "Use POST /api/pagos para realizar un pago, " +
            "o GET /api/pagos/metodos para ver las opciones."
        );
    }
}

