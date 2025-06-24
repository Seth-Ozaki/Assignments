package com.seth.dojoswithninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seth.dojoswithninjas.models.Dojo;
import com.seth.dojoswithninjas.models.Ninja;
import com.seth.dojoswithninjas.services.DojoService;
import com.seth.dojoswithninjas.services.NinjaService;

import jakarta.validation.Valid;



@Controller
@RequestMapping("/dojos")
public class DojoController {
	
	@Autowired
	DojoService dojoService;
	@Autowired
	NinjaService ninjaService;
	
	
	
	// Dashboard
	// Create form / Read All
	// route: /dojos
	@GetMapping("")
	public String index(@ModelAttribute("newDojo") Dojo newDojo,
			Model model) {
		List<Dojo> dojos = dojoService.getAll();
		model.addAttribute("dojos",dojos);
		return "index.jsp";
	}
	
	// Create dojo
	// route: /dojos
	@PostMapping("")
	public String submitDojo(@Valid @ModelAttribute("newDojo") Dojo newDojo,
			BindingResult result, Model model) {
			if(result.hasErrors()) {
				List<Dojo> dojos = dojoService.getAll();
				model.addAttribute("dojos",dojos);
				return "index.jsp";
			}else {
				dojoService.create(newDojo);
				return "redirect:/dojos";
			}
	}
	
	
	// Read One
	// route: /dojos/id
	@GetMapping("/{id}")
	public String oneDojo(Model model, @PathVariable("id") Long id) {
		Dojo dojo = dojoService.getOne(id);
		List<Ninja> ninjas = dojo.getDojosNinjas();
		model.addAttribute("dojo",dojo);
		model.addAttribute("ninjas",ninjas);
		return "oneDojo.jsp";
	}
	
	
	
	// Create Ninja form
	// route: dojos/new/ninja
	@GetMapping("/new/ninja")
	public String newNinja(@ModelAttribute("newNinja") Ninja newNinja, Model model) {
		List<Dojo> dojos = dojoService.getAll();
		model.addAttribute("dojos",dojos);
		return "newNinja.jsp";
	}
	
	
	// Create ninja
	// route: dojos/new/ninja
	@PostMapping("/new/ninja")
	public String submitNinja(@Valid @ModelAttribute("newNinja") Ninja newNinja, BindingResult result) {
		if(result.hasErrors()) {
			return "newNinja.jsp";
		}else {
			ninjaService.create(newNinja);
			return "redirect:/dojos";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
