package com.seth.ecom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.seth.ecom.models.LoginUser;
import com.seth.ecom.models.User;
import com.seth.ecom.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

	// Add once service is implemented:
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String index(Model model) {

		// Bind empty User and LoginUser objects to the JSP
		// to capture the form input
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
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

		return "redirect:/items";
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

		return "redirect:/items";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
