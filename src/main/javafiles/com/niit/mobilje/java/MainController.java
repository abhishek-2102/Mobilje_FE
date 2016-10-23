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
	
	
	
}
