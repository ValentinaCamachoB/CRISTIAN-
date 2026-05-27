package com.example.mvc_aprendices.service;

import com.example.mvc_aprendices.model.Aprendiz;
import org.springframework.stereotype.Service;
 
import java.util.ArrayList;
import java.util.List;
 
@Service
public class AprendizService {
 
    private List<Aprendiz> listaAprendices = new ArrayList<>();
    private int contadorId = 1;
 
    public AprendizService() {
        cargarDatosEjemplo();
    }
 
    public List<Aprendiz> obtenerTodos() {
        return listaAprendices;
    }
 
    public Aprendiz buscarPorId(int id) {
        return listaAprendices.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
    }
 
    /**
     * SOLO para crear aprendices nuevos.
     * Asigna ID automático y estado ACTIVO.
     */
    public void guardar(Aprendiz aprendiz) {
        aprendiz.setId(contadorId++);
        aprendiz.setEstado("ACTIVO");
        listaAprendices.add(aprendiz);
    }
 
    /**
     * SOLO para editar un aprendiz existente.
     * Busca por ID y actualiza los campos en el mismo objeto de la lista,
     * sin agregar un nuevo elemento.
     */
    public void actualizar(Aprendiz aprendizEditado) {
        Aprendiz existente = buscarPorId(aprendizEditado.getId());
        if (existente != null) {
            existente.setNombre(aprendizEditado.getNombre());
            existente.setCorreo(aprendizEditado.getCorreo());
            existente.setFicha(aprendizEditado.getFicha());
            existente.setPrograma(aprendizEditado.getPrograma());
            // No se toca el estado: se cambia solo con cambiarEstado()
        }
    }
 
    public void eliminar(int id) {
        listaAprendices.removeIf(a -> a.getId() == id);
    }
 
    public int contarTotal() {
        return listaAprendices.size();
    }
 
    public long contarActivos() {
        return listaAprendices.stream()
                .filter(Aprendiz::estaActivo)
                .count();
    }
 
    public void cambiarEstado(int id) {
        Aprendiz aprendiz = buscarPorId(id);
        if (aprendiz != null) {
            aprendiz.setEstado(aprendiz.estaActivo() ? "INACTIVO" : "ACTIVO");
        }
    }
 
    private void cargarDatosEjemplo() {
        listaAprendices.add(new Aprendiz(contadorId++, "Laura Gómez",
                "laura.gomez@sena.edu.co", "2758946", "Análisis y Desarrollo de Software", "ACTIVO"));
        listaAprendices.add(new Aprendiz(contadorId++, "Carlos Ríos",
                "carlos.rios@sena.edu.co", "2758946", "Análisis y Desarrollo de Software", "ACTIVO"));
        listaAprendices.add(new Aprendiz(contadorId++, "María Fernández",
                "maria.fernandez@sena.edu.co", "2812034", "Sistemas", "INACTIVO"));
        listaAprendices.add(new Aprendiz(contadorId++, "Andrés López",
                "andres.lopez@sena.edu.co", "2812034", "Sistemas", "ACTIVO"));
    }
}
