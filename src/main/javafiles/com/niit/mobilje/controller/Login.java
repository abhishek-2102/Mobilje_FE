package com.niit.mobilje.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.mobilje.dao.RegisterDao;
import com.niit.mobilje.trans.LoginDetails;

@Controller
@RequestMapping(value="/login_page")
public class Login {
	@Autowired
	RegisterDao reg;
	

	@RequestMapping(method =RequestMethod.GET)
	public String viewLoginPage(Map<String, Object> model,Model m)
	{
		
		m.addAttribute("onclicklogin",1);
		LoginDetails login = new LoginDetails();
		model.put("login_form",login);
		return"index";
	}
	
	@RequestMapping(method =RequestMethod.POST)
	public String perfLogin(@ModelAttribute("login_form") LoginDetails l,Map<String, Object> model,Model m,HttpSession sess)
	{
		System.out.println(l.getLogin_email());
		System.out.println(l.getLogin_password());
		
			if(reg.isValidUser(l))
				{
				m.addAttribute("onclicklogin",1);
				m.addAttribute("error",true);
				m.addAttribute("logError","login successful");
				//admin
				//if the person is admin or end user
				if(reg.isRole().equals("admin")){
					m.addAttribute("onclickAdminHome",1);
					return "AdminHome";
				}
				else{
					return "index";
				}
			}//error message
			
			else{
				m.addAttribute("onclicklogin",1);
				
				m.addAttribute("error",true);
				m.addAttribute("logError","Username and password do not match");
				return "index";
				}
	}//end login
}

