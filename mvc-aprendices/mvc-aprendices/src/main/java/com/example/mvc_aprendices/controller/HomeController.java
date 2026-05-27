package com.example.mvc_aprendices.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // redirige automáticamente a /aprendices
    @GetMapping("/")
    public String inicio() {
        return "redirect:/aprendices";
    }
}