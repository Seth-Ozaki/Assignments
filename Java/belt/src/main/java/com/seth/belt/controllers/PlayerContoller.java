package com.seth.belt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seth.belt.models.Player;
import com.seth.belt.models.Team;
import com.seth.belt.services.PlayerService;
import com.seth.belt.services.TeamService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/players")
public class PlayerContoller {
	
	@Autowired
	private PlayerService playerService;
	@Autowired
	private TeamService teamService;
	
	// Create
	// route: /players/new
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("newPlayer") Player newPlayer, BindingResult result, HttpSession session, Model model) {
		if (session.getAttribute("name") == null) {

			return "redirect:/";
		}
		Team team = teamService.getOneTeam(newPlayer.getTeam().getId());
		if(team.getTeamPlayers().size()== 9) {
			result.rejectValue("playerName", "size", "Sorry this team is full 9/9");
			model.addAttribute(team);
			return "oneTeam.jsp";
		}
		if (result.hasErrors()) {
			model.addAttribute(team);
			return "oneTeam.jsp";
		} else {
			playerService.createPlayer(newPlayer);
			model.addAttribute(team);
			return "redirect:/teams/"+team.getId();
		}
}	













}


