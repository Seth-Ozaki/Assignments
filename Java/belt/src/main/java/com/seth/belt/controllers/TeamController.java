package com.seth.belt.controllers;

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

import com.seth.belt.models.Player;
import com.seth.belt.models.Team;
import com.seth.belt.services.TeamService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/teams")
public class TeamController {

	@Autowired
	private TeamService teamService;

	// Create Form
	// route: /teams/new
	@GetMapping("/new")
	public String newTeam(@ModelAttribute("newTeam") Team newTeam, HttpSession session) {
		if (session.getAttribute("name") == null) {

			return "redirect:/";
		}
		return "newTeam.jsp";
	}

	// Create
	// route: /teams/new
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("newTeam") Team newTeam, BindingResult result, HttpSession session) {
		if (session.getAttribute("name") == null) {

			return "redirect:/";
		}
		if (result.hasErrors()) {
			return "newTeam.jsp";
		} else {
			teamService.createTeam(newTeam);
			return "redirect:/home";
		}
	}

	// Read One
	// route: /teams/id
	@GetMapping("/{id}")
	public String readOne(@PathVariable("id") Long id, Model model, HttpSession session,
			@ModelAttribute("newPlayer") Player newPlayer) {
		if (session.getAttribute("name") == null) {

			return "redirect:/";
		}
		Team team = teamService.getOneTeam(id);
		model.addAttribute(team);
		return "oneTeam.jsp";
	}

	// Update Page
	// route: /teams/edit/id
	@GetMapping("/edit/{id}")
	public String updateTeam(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("name") == null) {

			return "redirect:/";
		}
		Team editTeam = teamService.getOneTeam(id);
		model.addAttribute("editTeam",editTeam);
		return "editTeam.jsp";
	}

	// Update
	// route: /teams/edit/id
	@PutMapping("/edit/{id}")
	public String update(@Valid @ModelAttribute("editTeam") Team editedTeam, BindingResult result, Model model,
			@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("name") == null) {

			return "redirect:/";
		}
		if (result.hasErrors()) {
			model.addAttribute("editTeam", editedTeam);
			return "editTeam.jsp";
		} else {
			teamService.updateTeam(editedTeam);
			return "redirect:/teams/{id}";
		}

	}
	
	// Delete
	// route: /teams/delete/id
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, HttpSession session) {
		if (session.getAttribute("name") == null) {

			return "redirect:/";
		}
		teamService.deleteTeam(id);
		return "redirect:/home";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
