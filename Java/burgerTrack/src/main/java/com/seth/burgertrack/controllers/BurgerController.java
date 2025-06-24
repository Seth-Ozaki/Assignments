package com.seth.burgertrack.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.seth.burgertrack.models.Burger;
import com.seth.burgertrack.services.BurgerService;

import jakarta.validation.Valid;





@Controller
@RequestMapping("/burgers")
public class BurgerController {
	@Autowired
	BurgerService burgerService;
	
	//CRUD----------------
	
	// Create
	// return: "redirect:"
	// route: /burgers
	@PostMapping("")
	public String createBurger(@Valid @ModelAttribute("newBurger") Burger newBurger, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}else {
			burgerService.createBurger(newBurger);
			return "redirect:/burgers";
		}
	}
	
	
	// Read One
	// return: String
	// route: /burgers/id
	@GetMapping("/{id}")
	public String getOneBurger(@PathVariable("id") Long id, Model model) {
		Burger burger = burgerService.getOneBurger(id);
		model.addAttribute(burger);
		return "oneBurger.jsp";
	}
	
	// Read All
	// return: String
	// route: /burgers
	@GetMapping("")
	public String getAllBurgers(
			@ModelAttribute("newBurger") Burger newBurger,
			Model model) {
		List<Burger> burgers = burgerService.getAllBurgers();
		model.addAttribute("burgers",burgers);
		return "index.jsp";
		
	}
	
	// Update Page
	// return: String
	// route: /burgers/edit/{id}
	@GetMapping("/edit/{id}")
	public String updatePage(@PathVariable("id")Long id, Model model) {
		Burger oneBurger = burgerService.getOneBurger(id);
		model.addAttribute("oneBurger", oneBurger);
		return "update.jsp";
	}
	
	// Update Method
	// return: String
	// route: /burgers/edit/{id}
	@PutMapping("/edit/{id}")
	public String update(@Valid @ModelAttribute("oneBurger") Burger oneBurger, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("oneBurger", oneBurger);
			return "update.jsp";
		}else {
			burgerService.updateBurger(oneBurger);
			return "redirect:/burgers";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
