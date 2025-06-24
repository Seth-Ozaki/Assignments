package com.seth.hoppersreceipt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class ReceiptController {
	
    @GetMapping("/")
    public String index(Model model) {
        
        String name = "Grace Hopper";
        String itemName = "Copper wire";
        double price = 5.25;
        String description = "Metal strips, also an illustration of nanoseconds.";
        String vendor = "Little Things Corner Store";
    
    	// Your code here! Add values to the view model to be rendered
        model.addAttribute("name", name);
        model.addAttribute("itemName", itemName);
        model.addAttribute("price", price);
        model.addAttribute("description", description);
        model.addAttribute("vendor", vendor);
    
        return "index.jsp";
    
    
    }
    
    @GetMapping("/test")
    public String indexTest(Model model) {
        
        String name = "Seth Ozaki";
        String itemName = "Loose Beans";
        double price = 3.69;
        String description = "As the name implies, loose beans, idk couldnt think of anything less dumb ¯|_(;-;)_|¯";
        String vendor = "The Loose Bean Bandit";
    
    	// Your code here! Add values to the view model to be rendered
        model.addAttribute("name", name);
        model.addAttribute("itemName", itemName);
        model.addAttribute("price", price);
        model.addAttribute("description", description);
        model.addAttribute("vendor", vendor);
    
        return "index.jsp";
    
    
    }
}