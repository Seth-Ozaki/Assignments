package com.seth.omikujiform.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class FormController {
	
	@GetMapping("/")
	public String index() {
		return "redirect:/omikuji";
	}
	
	@GetMapping("/omikuji")
	public String form() {
		return "index.jsp";
	}
	
	@PostMapping("/submit")
	public String submit(@RequestParam("number") String number, 
			@RequestParam("city") String city,
			@RequestParam("name") String name,
			@RequestParam("hobby") String hobby,
			@RequestParam("thing") String thing,
			@RequestParam("nice") String nice, 
			HttpSession session
			) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("name", name);
		session.setAttribute("hobby", hobby);
		session.setAttribute("thing", thing);
		session.setAttribute("nice", nice);
		
		
		return "redirect:/results";
	}
	
	@GetMapping("/results")
		public String results() {
			return "formResults.jsp";
		}
	
	
	
}
