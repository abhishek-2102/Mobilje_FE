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
import com.niit.mobilje.trans.LoginVals;

@Controller
@RequestMapping(value="/login_page")
public class Login {
	
	@Autowired
	RegisterDao reg;
	
	@Autowired
	LoginVals lg;
	
	@RequestMapping(method =RequestMethod.GET)
	public String viewLoginPage(Map<String, Object> model,Model m,HttpSession sess)
	{
		lg.setSignIn("Sing In");
		lg.setSignUp("Sign Up");
		
		sess.setAttribute("username"," ");
		
		sess.setAttribute("SignIn", lg.getSignIn());
		sess.setAttribute("SignUp", lg.getSignUp());
		
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
				lg.setSignIn("Log Out");
				lg.setSignUp("Sign Up");
				
				sess.setAttribute("SignIn", lg.getSignIn());
				sess.setAttribute("SignUp", lg.getSignUp());
				
				String name=reg.userName();
				
				
				sess.setAttribute("username","Welcome "+name);
				
				//admin
				//if the person is admin or end user
				
				if(reg.isRole().equals("admin"))
				{
					m.addAttribute("onclickAdminHome",1);
					return "AdminHome";
				}
				else{
					
					m.addAttribute("toHome",1);
					m.addAttribute("error",true);
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

