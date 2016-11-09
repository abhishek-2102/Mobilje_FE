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
@Transactional
public class Registration {
	
	@Autowired
	RegisterDao reg;
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewRegPage(Map<String, Object> model,Model m)
	{
		m.addAttribute("onclickRegPage",1);
		RegisterDetails user= new RegisterDetails();
		model.put("user_form",user);
		return "index";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String prosReg(@ModelAttribute("user_form") RegisterDetails u, Map<String,Object> model,Model m)
	{
			m.addAttribute("onclickReg",1);
			reg.saveRegister(u);
			System.out.println("username: " + u.getUsername());
	        System.out.println("password: " + u.getPassword());
	        System.out.println("email: " + u.getEmail());
	        System.out.println("birth date: " + u.getNumber());
	        System.out.println("address: " + u.getAddress());
	        System.out.println("DOB: " + u.getDob());
	        System.out.println("Gender: " + u.getGender()); 	
		return "index";
	}
}

