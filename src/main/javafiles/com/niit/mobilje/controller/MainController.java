package com.niit.mobilje.controller;

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
	
	@RequestMapping("/about_us")
	public String gotoaboutus(Model m)
	{
		m.addAttribute("onclickAbout_Us",1);
		return"index";
	}
	
	@RequestMapping("/contact_us")
	public String gotocontactus(Model m)
	{
		m.addAttribute("onclickContact",1);
		return"index";
	}
	
	
	
}
