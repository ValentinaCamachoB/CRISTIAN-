package com.example.mvc_aprendices.controller;

import com.example.mvc_aprendices.model.Aprendiz;
import com.example.mvc_aprendices.service.AprendizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
 
@Controller
@RequestMapping("/aprendices")
public class AprendizController {
 
    @Autowired
    private AprendizService aprendizService;
 
    // Lista todos los aprendices
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("aprendices", aprendizService.obtenerTodos());
        model.addAttribute("total", aprendizService.contarTotal());
        model.addAttribute("activos", aprendizService.contarActivos());
        return "aprendices/lista";
    }
 
    // Muestra el formulario de REGISTRO (objeto vacío, sin ID)
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("aprendiz", new Aprendiz());
        return "aprendices/formulario"; // → templates/aprendices/formulario.html
    }
 
    // Recibe el formulario de REGISTRO y crea un aprendiz nuevo
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Aprendiz aprendiz) {
        aprendizService.guardar(aprendiz);
        return "redirect:/aprendices";
    }
 
    // Muestra el formulario de EDICIÓN con los datos actuales del aprendiz
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        model.addAttribute("aprendiz", aprendizService.buscarPorId(id));
        return "aprendices/editar"; // → templates/aprendices/editar.html
    }
 
    // Recibe el formulario de EDICIÓN y actualiza el aprendiz existente (sin agregar uno nuevo)
    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Aprendiz aprendiz) {
        aprendizService.actualizar(aprendiz);
        return "redirect:/aprendices";
    }
 
    // Muestra el detalle de un aprendiz
    @GetMapping("/detalle/{id}")
    public String detalle(@PathVariable int id, Model model) {
        model.addAttribute("aprendiz", aprendizService.buscarPorId(id));
        return "aprendices/detalle";
    }
 
    // Elimina un aprendiz
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        aprendizService.eliminar(id);
        return "redirect:/aprendices";
    }
 
    // Cambia el estado activo/inactivo
    @GetMapping("/cambiarEstado/{id}")
    public String cambiarEstado(@PathVariable int id) {
        aprendizService.cambiarEstado(id);
        return "redirect:/aprendices/detalle/" + id;
    }
}