package com.example.SistemaAcademico.service;

import org.springframework.stereotype.Service;

@Service
public class EstadisticasService {

    private int consultasAprendices = 0;
    private int consultasInstructores = 0;
    private int consultasProgramas = 0;

    public EstadisticasService() {
        System.out.println("EstadisticasService creado - instancia: " + this.hashCode());
    }

    public void sumarAprendiz() {
        consultasAprendices++;
    }

    public void sumarInstructor() {
        consultasInstructores++;
    }

    public void sumarPrograma() {
        consultasProgramas++;
    }

    public int getConsultasAprendices() {
        return consultasAprendices;
    }

    public int getConsultasInstructores() {
        return consultasInstructores;
    }

    public int getConsultasProgramas() {
        return consultasProgramas;
    }

    public int getTotalConsultas() {
        return consultasAprendices + consultasInstructores + consultasProgramas;
    }

}

