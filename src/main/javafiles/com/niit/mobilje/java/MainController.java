package com.niit.mobilje.java;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
	
	@RequestMapping("/")
	public String gotohome(Model m)
	{
		return "index";
	}
	
	@RequestMapping("/home")
	public String gotoindex(Model m)
	{
		m.addAttribute("onclickhome",1);
		return "index";
	}
	
	
	@RequestMapping("/login_page")
	public String gotologin(Model m)
	{
		m.addAttribute("onclickLogin",1);
		return "index";
	}
	
	
	
	
}
