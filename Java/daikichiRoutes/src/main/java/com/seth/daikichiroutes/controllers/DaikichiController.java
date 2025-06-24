package com.seth.daikichiroutes.controllers;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class DaikichiController {
	
	@GetMapping("/daikichi")
	public String home() {
		return "Welcome";
	}
	
	@GetMapping("/daikichi/today")
	public String today() {
		return "Today you will find luck in all your endeavors!";
	}
	
	@GetMapping("/daikichi/tomorrow")
	public String tomorrow() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
	
	@GetMapping("/daikichi/travel/{location}")
	public String location(@PathVariable("location") String location) {
		return "Congratulations! You will soon travel to " + location;
	}
	
	@GetMapping("/daikichi/lotto/{number}")
	public String lotto(@PathVariable("number") int number) {
		if(number % 2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		}else {
			
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		}	
	}
	
	
}
