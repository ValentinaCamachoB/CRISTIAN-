package com.example.SistemaAcademico.controller;

import com.example.SistemaAcademico.service.EstadisticasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aprendices")
public class AprendizController {

    private final EstadisticasService estadisticasService;

    public AprendizController(EstadisticasService estadisticasService) {
        this.estadisticasService = estadisticasService;
    }

    @GetMapping
    public String consultarAprendices() {
        estadisticasService.sumarAprendiz();
        return "Consulta de aprendices realizada. Total de consultas hasta ahora: " + estadisticasService.getTotalConsultas();
    }

}
