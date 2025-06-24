package com.seth.ninjagoldgame.controllers;


import java.util.ArrayList;
import java.util.Random;
import java.util.Date;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class GameController {
	
	@GetMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		
		if (session.getAttribute("activity") == null) {
			session.setAttribute("activity",new ArrayList<String>());
		}
//		session.setAttribute("gold", 0);
//		session.setAttribute("activity",new ArrayList<String>());
//		System.out.println(session.getAttribute("activity"));
		return "index.jsp";
	}

	@PostMapping("/choice")
	public String choice(@RequestParam("choice") String choice, HttpSession session) {
		if (choice.equals("1")) {
			Random rng  = new Random();
			int min = 10;
			int max = 20;
			int gain = rng.nextInt(max-min+1)+min;
			
			Integer current = (Integer)session.getAttribute("gold");
			current+=gain;
			session.setAttribute("gold", current);
			
			Date date = new Date(); 
			@SuppressWarnings("unchecked")
			ArrayList<String> activity = (ArrayList<String>)session.getAttribute("activity");
			String add = String.format("You entered a Farm and earned %s gold (%s)", gain, date);
			activity.add(add);

			return "redirect:/";
		}
		if (choice.equals("2")) {
			Random rng  = new Random();
			int min = 5;
			int max = 10;
			int gain = rng.nextInt(max-min+1)+min;
			
			Integer current = (Integer)session.getAttribute("gold");
			current+=gain;
			session.setAttribute("gold", current);
			
			
			Date date = new Date(); 
			@SuppressWarnings("unchecked")
			ArrayList<String> activity = (ArrayList<String>)session.getAttribute("activity");
			String add = String.format("You entered a cave and earned %s gold (%s)", gain, date);
			activity.add(add);
			
			return "redirect:/";
		}
		if (choice.equals("3")) {
			Random rng  = new Random();
			int min = 2;
			int max = 5;
			int gain = rng.nextInt(max-min+1)+min;
			
			Integer current = (Integer)session.getAttribute("gold");
			current+=gain;
			session.setAttribute("gold", current);

			Date date = new Date(); 
			@SuppressWarnings("unchecked")
			ArrayList<String> activity = (ArrayList<String>)session.getAttribute("activity");
			String add = String.format("You entered a House and earned %s gold (%s)", gain, date);
			activity.add(add);
			
			return "redirect:/";
		}
		if (choice.equals("4")) {
			Random rng  = new Random();
			int min = -50;
			int max = 50;
			int gain = rng.nextInt(max-min+1)+min;
			
			Integer current = (Integer)session.getAttribute("gold");
			current+=gain;
			session.setAttribute("gold", current);
			
			Date date = new Date(); 
			@SuppressWarnings("unchecked")
			ArrayList<String> activity = (ArrayList<String>)session.getAttribute("activity");
			if(gain==0) {
				String add = String.format("Well that was a waste of time... %s gold (%s)", gain, date);
				activity.add(add);
			}else if(gain>0) {
				String add = String.format("You completed a quest and earned %s gold (%s)", gain, date);
				activity.add(add);
			}else {
				String add = String.format("You failed a quest and spent %s gold (%s)", gain, date);
				activity.add(add);
				session.setAttribute("color","red");
			}
			

			return "redirect:/";
		}
		if (choice.equals("5")) {
			Random rng  = new Random();
			int min = -20;
			int max = -5;
			int gain = rng.nextInt(max-min+1)+min;
			
			Integer current = (Integer)session.getAttribute("gold");
			current+=gain;
			session.setAttribute("gold", current);
			
			Date date = new Date(); 
			@SuppressWarnings("unchecked")
			ArrayList<String> activity = (ArrayList<String>)session.getAttribute("activity");
			String add = String.format("Went to the spa and spent %s gold (%s)", gain, date);
			activity.add(add);
			session.setAttribute("color","red");

			return "redirect:/";
		}

		return "redirect:/";
	}
	
	@GetMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("gold", 0);
		session.setAttribute("activity",new ArrayList<String>());
		return "redirect:/";
	}
	

}
