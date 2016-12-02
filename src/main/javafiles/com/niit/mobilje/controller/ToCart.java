package com.niit.mobilje.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ToCart {
	
	
	
	
	
	@RequestMapping(value="/tocart")
	public String dispCartPage(@RequestParam("pid") String id,Model m){
		
		
		
		
		m.addAttribute("toCart",1);
		return "index";
	}//display cart page
}