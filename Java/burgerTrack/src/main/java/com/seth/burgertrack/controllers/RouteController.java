package com.seth.burgertrack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {
	@GetMapping("/")
	public String baseRoute() {
		return "redirect:/burgers";
	}
}
