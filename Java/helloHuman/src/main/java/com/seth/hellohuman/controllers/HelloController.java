package com.seth.hellohuman.controllers;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class HelloController {
	
	@GetMapping("/")
	public String home() {
		return "Hello Human";
	}
	
	@GetMapping("/{name}")
	public String name(@PathVariable("name") String name) {
		return "Hello " + name;
	}
	
	@GetMapping("/{name}/{last}")
	public String nameLast(@PathVariable("name") String name, @PathVariable("last") String last) {
		return "Hello " + name + " " + last;
	}
	
	@GetMapping("/times/{name}/{amount}")
	public String nameAmount(@PathVariable("name") String name, @PathVariable("amount") int amount) {
		String output= " Hello " + name;
		return output.repeat(amount);
	}
	
	
}
