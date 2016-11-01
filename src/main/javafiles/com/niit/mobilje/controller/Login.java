package com.niit.mobilje.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/login_page")
public class Login {
	
	@RequestMapping(method =RequestMethod.GET)
	public String viewLoginPage(Model m)
	{
		m.addAttribute("onclicklogin",1);
		return"index";
	}
	
	@RequestMapping(method =RequestMethod.POST)
	public String perfLogin(Model m)
	{
		m.addAttribute("onclickloginbutton",1);
		return"index";
	}
	

}

