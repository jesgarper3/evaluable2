package com.midominio.evaluable2.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class DemoErrorController {


	@GetMapping("/division-por-0")
	public String m2() {
		int x = 1 / 0;
		return "";
	}


}
