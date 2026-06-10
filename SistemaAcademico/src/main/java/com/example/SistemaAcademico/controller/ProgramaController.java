package com.example.SistemaAcademico.controller;

import com.example.SistemaAcademico.service.EstadisticasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/programas")
public class ProgramaController {

    private final EstadisticasService estadisticasService;

    public ProgramaController(EstadisticasService estadisticasService) {
        this.estadisticasService = estadisticasService;
    }

    @GetMapping
    public String consultarProgramas() {
        estadisticasService.sumarPrograma();
        return "Consulta de programas realizada. Total de consultas hasta ahora: " + estadisticasService.getTotalConsultas();
    }

}
