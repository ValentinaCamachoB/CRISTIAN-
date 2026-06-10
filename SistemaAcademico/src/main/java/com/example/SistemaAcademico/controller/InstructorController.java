package com.example.SistemaAcademico.controller;

import com.example.SistemaAcademico.service.EstadisticasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instructores")
public class InstructorController {

    private final EstadisticasService estadisticasService;

    public InstructorController(EstadisticasService estadisticasService) {
        this.estadisticasService = estadisticasService;
    }

    @GetMapping
    public String consultarInstructores() {
        estadisticasService.sumarInstructor();
        return "Consulta de instructores realizada. Total de consultas hasta ahora: " + estadisticasService.getTotalConsultas();
    }

}