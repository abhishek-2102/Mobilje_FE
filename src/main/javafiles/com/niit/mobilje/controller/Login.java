package com.niit.mobilje.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.mobilje.trans.LoginDetails;

@Controller
@RequestMapping(value="/login_page")
public class Login {
	
	@RequestMapping(method =RequestMethod.GET)
	public String viewLoginPage(Map<String, Object> model,Model m)
	{
		m.addAttribute("onclicklogin",1);
		LoginDetails login = new LoginDetails();
		model.put("login_form",login);
		return"index";
	}
	
	@RequestMapping(method =RequestMethod.POST)
	public String perfLogin(@ModelAttribute("login_form") LoginDetails l,Map<String, Object> model,Model m)
	{
		m.addAttribute("onclickloginbutton",1);
		System.out.println(l.getLogin_email());
		System.out.println(l.getLogin_password());
		return"index";
	}
	

}

