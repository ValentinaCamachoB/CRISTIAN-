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
 
    // Muestra la lista de todos los aprendices
    @GetMapping
    public String listar(Model model) {
        // 1. Pedimos los datos al servicio (Model)
        model.addAttribute("aprendices", aprendizService.obtenerTodos());
        model.addAttribute("total", aprendizService.contarTotal());
        model.addAttribute("activos", aprendizService.contarActivos());
 
        // 2. Retornamos el nombre de la plantilla Thymeleaf (View)
        return "aprendices/lista";  // → templates/aprendices/lista.html
    }

    // Muestra el formulario para registrar
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        // Enviamos un objeto vacío a la vista para que Thymeleaf lo llene
        model.addAttribute("aprendiz", new Aprendiz());
        return "aprendices/formulario";  // → templates/aprendices/formulario.html
    }
 
    //  Recibe los datos del formulario y los guarda
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Aprendiz aprendiz) {
        // @ModelAttribute captura automáticamente los campos del formulario
        aprendizService.guardar(aprendiz);
 
        // Redirigimos a la lista después de guardar
        return "redirect:/aprendices";
    }
 
    //  Muestra el detalle de un aprendiz
    @GetMapping("/detalle/{id}")
    public String detalle(@PathVariable int id, Model model) {
        Aprendiz aprendiz = aprendizService.buscarPorId(id);
        model.addAttribute("aprendiz", aprendiz);
        return "aprendices/detalle";  // → templates/aprendices/detalle.html
    }
 
    //  Elimina un aprendiz
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        aprendizService.eliminar(id);
        return "redirect:/aprendices";

    @GetMapping("/cambiarEstado/{id}")
    public String cambiarEstado(@PathVariable int id) {
        aprendizService.cambiarEstado(id);
        return "redirect:/aprendices/detalle/" + id;
    }
}
