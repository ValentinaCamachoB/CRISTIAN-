package com.example.mvc_aprendices.service;

import com.example.mvc_aprendices.model.Aprendiz;
import org.springframework.stereotype.Service;
 
import java.util.ArrayList;
import java.util.List;
 
@Service  
public class AprendizService {
 
    // Simular la "base de datos" con una lista en memoria
    private List<Aprendiz> listaAprendices = new ArrayList<>();
    private int contadorId = 1;
 
    // Constructor: cargamos datos de ejemplo al iniciar
    public AprendizService() {
        cargarDatosEjemplo();
    }
 
    /**
     * Retorna la lista completa de aprendices.
     */
    public List<Aprendiz> obtenerTodos() {
        return listaAprendices;
    }
 
    /**
     * Busca un aprendiz por su ID.
     * Regla de negocio: si no existe, retorna null.
     */
    public Aprendiz buscarPorId(int id) {
        return listaAprendices.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
    }
 
    /**
     * Guarda un nuevo aprendiz.
     * Regla de negocio: asigna automáticamente el ID y estado ACTIVO.
     */
    public void guardar(Aprendiz aprendiz) {
        aprendiz.setId(contadorId++);
        aprendiz.setEstado("ACTIVO");
        listaAprendices.add(aprendiz);
    }
 
    /**
     * Elimina un aprendiz por ID.
     */
    public void eliminar(int id) {
        listaAprendices.removeIf(a -> a.getId() == id);
    }
 
    /**
     * Retorna cuántos aprendices hay en total.
     */
    public int contarTotal() {
        return listaAprendices.size();
    }
 
    /**
     * Retorna cuántos aprendices están activos.
     */
    public long contarActivos() {
        return listaAprendices.stream()
                .filter(Aprendiz::estaActivo)
                .count();
    }

    /**
     *  si está ACTIVO pasa a INACTIVO, y viceversa.
     */
    public void cambiarEstado(int id) {
        Aprendiz aprendiz = buscarPorId(id);
        if (aprendiz != null) {
            if (aprendiz.estaActivo()) {
                aprendiz.setEstado("INACTIVO");
            } else {
                aprendiz.setEstado("ACTIVO");
            }
        }
    }
 
    // Carga datos de ejemplo para mostrar en la aplicación
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
