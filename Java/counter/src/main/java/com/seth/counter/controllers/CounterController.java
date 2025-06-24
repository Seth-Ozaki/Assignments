package com.seth.counter.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;


@Controller
public class CounterController {

	@GetMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null ) {
			session.setAttribute("count", 0);
		}
		return "index.jsp";
	}
	
	@GetMapping("/count")
	public String Count(HttpSession session) {
		Integer count = (Integer)session.getAttribute("count");
		count++;
		session.setAttribute("count",count);	
		return "count.jsp";
	}
	@GetMapping("/countTwo")
	public String CountTwo(HttpSession session) {
		Integer count = (Integer)session.getAttribute("count");
		count+=2;
		session.setAttribute("count",count);
		return "countTwo.jsp";
	}
	
	@GetMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("count",null);
		return "redirect:/count";
	}
}
