package com.niit.mobilje.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.mobilje.dao.RegisterDao;
import com.niit.mobilje.trans.RegisterDetails;

@Controller
@RequestMapping(value="/reg_page")

public class Registration {
	
	@Autowired
	RegisterDao reg;
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewRegPage(Map<String,Object> model,Model m)
	{
		m.addAttribute("onclickRegPage",1);
		RegisterDetails user= new RegisterDetails();
		model.put("user_form",user);
		return "index";
	}//end get

	@RequestMapping(method = RequestMethod.POST)
	public String prosReg(@ModelAttribute("user_form") RegisterDetails u, Map<String,Object> model,Model m)
	{
			m.addAttribute("onclickReg",1);
			reg.saveRegister(u);
			System.out.println("Data received");
		return "index";
	}//end post
	
	
}//end class

