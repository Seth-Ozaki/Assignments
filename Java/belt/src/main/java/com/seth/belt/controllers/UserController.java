package com.seth.belt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.seth.belt.models.LoginUser;
import com.seth.belt.models.Team;
import com.seth.belt.models.User;
import com.seth.belt.services.TeamService;
import com.seth.belt.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private TeamService teamService;

	@GetMapping("/")
	public String index(Model model) {

		// Bind empty User and LoginUser objects to the JSP
		// to capture the form input
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}

	@GetMapping("/home")
	public String home(HttpSession session, Model model) {

		if (session.getAttribute("name") == null) {

			return "redirect:/";
		}
		List<Team> teams = teamService.getAllTeams();
		model.addAttribute("teams",teams);
		return "dashboard.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {

		User user = userService.register(newUser, result);

		if (result.hasErrors()) {
			// Be sure to send in the empty LoginUser before
			// re-rendering the page.(Freaks out w/out)
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}

		session.setAttribute("name", user.getUserName());
		session.setAttribute("id", user.getId());

		return "redirect:/home";
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {

		User loggedUser = userService.login(newLogin, result);

		if (result.hasErrors()) {
			// Be sure to send in the empty newUser before
			// re-rendering the page.(Freaks out w/out)
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}

		session.setAttribute("id", loggedUser.getId());
		session.setAttribute("name", loggedUser.getUserName());

		return "redirect:/home";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}