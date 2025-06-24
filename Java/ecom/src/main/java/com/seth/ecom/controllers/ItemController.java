package com.seth.ecom.controllers;



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

import com.seth.ecom.models.Item;
import com.seth.ecom.models.User;
import com.seth.ecom.services.ItemService;
import com.seth.ecom.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/items")
public class ItemController {
	@Autowired
	ItemService itemService;
	@Autowired
	UserService userService;
	
	// Create form
	// route: /items/new
	@GetMapping("/new")
	public String createForm(@ModelAttribute("newItem") Item newItem) {
		return "newItem.jsp";
	}
	
	// Create 
	// route: /items/new
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("newItem") Item newItem, BindingResult result){
		if(result.hasErrors()) {
			return "newItem.jsp";
		}else {
			itemService.create(newItem);
			return "redirect:/items";
		}
	}
	
	// Read All
	// route: /items
	@GetMapping("")
	public String home(HttpSession session, Model model) {
		if (session.getAttribute("id") == null) {

			return "redirect:/";
		}
		List<Item> items = itemService.getAll();
		model.addAttribute("items",items);
		Long isAdmin = (Long) session.getAttribute("id");
		model.addAttribute("isAdmin", isAdmin);
		
		return "dashboard.jsp";
	}
	
	// Read One
	// route: /items/id
	@GetMapping("/{id}")
	public String getOne(@PathVariable("id")Long id,Model model) {
		Item item = itemService.getOne(id);
		model.addAttribute(item);
		return "oneItem.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
