package com.midominio.evaluable2.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping({"/","/home"})
	public String home(Model model) {
		model.addAttribute("titulo", "Home");
		model.addAttribute("cabecera", "Bienvenido al mundo de la lectura");
		model.addAttribute("texto", "Leer te da más, el saber no ocupa lugar y tambien puedes acceder a estos enlaces");

		return "index";

	}
}
