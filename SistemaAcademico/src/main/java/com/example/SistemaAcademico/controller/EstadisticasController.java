package com.example.SistemaAcademico.controller;

import com.example.SistemaAcademico.service.EstadisticasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estadisticas")
public class EstadisticasController {

    private final EstadisticasService estadisticasService;

    public EstadisticasController(EstadisticasService estadisticasService) {
        this.estadisticasService = estadisticasService;
    }

    @GetMapping
    public String verEstadisticas() {
        return "Consultas aprendices: " + estadisticasService.getConsultasAprendices() + "\n"
             + "Consultas instructores: " + estadisticasService.getConsultasInstructores() + "\n"
             + "Consultas programas: " + estadisticasService.getConsultasProgramas() + "\n"
             + "Total general: " + estadisticasService.getTotalConsultas();
    }

}