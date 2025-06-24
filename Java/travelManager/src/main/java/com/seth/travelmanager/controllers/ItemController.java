package com.seth.travelmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.seth.travelmanager.models.Item;
import com.seth.travelmanager.services.ItemService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/items")
public class ItemController {

	@Autowired
	ItemService itemService;

	// CRUD--------------

	// Create
	// return: String
	// route: /items
	@PostMapping("")
	public String create(@Valid @ModelAttribute("newItem") Item newItem, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			itemService.create(newItem);
			return "redirect:/items";
		}
	}

	// Read One
	// return: String
	// route: /items/id
	@GetMapping("/{id}")
	public String readOne(Model model, @PathVariable("id") Long id) {

		Item item = itemService.getOne(id);
		model.addAttribute(item);

		return "readOne.jsp";
	}

	// Read All
	// return: String
	// route: /objects
	@GetMapping("")
	public String getAll(@ModelAttribute("newItem") Item newItem, Model model) {
		List<Item> items = itemService.getAll();
		model.addAttribute("items", items);
		return "index.jsp";
	}

	// Update Page
	// return: String
	// route: /items/edit/{id}
	@GetMapping("/edit/{id}")
	public String updatePage(@PathVariable("id") Long id, Model model) {
		Item oneItem = itemService.getOne(id);
		model.addAttribute("oneItem", oneItem);
		return "update.jsp";
	}

	// Update Method
	// return: String
	// route: /items/edit/{id}
	@PutMapping("/edit/{id}")
	public String update(@Valid @ModelAttribute("oneItem") Item oneItem, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("oneItem", oneItem);
			return "update.jsp";
		} else {
			itemService.update(oneItem);
			return "redirect:/";
		}
	}

	// Delete
	// return String
	// route /items/delete/{id}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes flash) {
		itemService.delete(id);
		flash.addFlashAttribute("deleted", "Item has been deleted.");
		return "redirect:/";
	}

}
