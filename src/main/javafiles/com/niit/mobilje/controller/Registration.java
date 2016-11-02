package com.niit.mobilje.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/reg_page")

public class Registration {
	
	@RequestMapping(method = RequestMethod.GET)

	public String viewRegPage(Map<String, Object> model,Model m)
	{
		m.addAttribute("onclickRegPage",1);
		UserDetails user= new UserDetails();
		model.put("user_form",user);
		return "index";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String prosReg(@ModelAttribute("user_form") UserDetails u, Map<String,Object> model,Model m)
	{
			m.addAttribute("onclickReg",1);
			System.out.println("username: " + u.getUsername());
	        System.out.println("password: " + u.getPassword());
	        System.out.println("email: " + u.getEmail());
	        System.out.println("birth date: " + u.getNumber());
	        System.out.println("address: " + u.getAddress());
	        System.out.println("DOB: " + u.getDob());
	         	
		return "index";
	}
}

