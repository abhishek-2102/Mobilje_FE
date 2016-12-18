package com.niit.mobilje.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.mobilje.dao.CartDao;
import com.niit.mobilje.dao.RegisterDao;
import com.niit.mobilje.trans.CartDetails;
import com.niit.mobilje.trans.LoginDetails;
import com.niit.mobilje.trans.LoginVals;

@Controller
@RequestMapping
public class Login {
	
	@Autowired
	RegisterDao reg;
	
	@Autowired
	LoginVals lg;
	
	@Autowired
	CartDao cart;
	
	@RequestMapping(value="/login_page")
	public String viewLoginPage(Map<String, Object> model,Model m,HttpSession sess)
	{
		lg.setSignIn("Sing In");
		lg.setSignUp("Sign Up");
		
		sess.setAttribute("username"," ");
		
		sess.setAttribute("SignIn", lg.getSignIn());
		sess.setAttribute("SignUp", lg.getSignUp());
		
		m.addAttribute("onclicklogin",1);
		LoginDetails login = new LoginDetails();
		
		/*model.put("login_form",login);*/
		System.out.println("Login Get");
		sess.setAttribute("Cart","null");
		
		sess.setAttribute("size","0");
		
		return"index";
	}
	
	@RequestMapping(value="/login_success",method =RequestMethod.POST)
	public String perfLogin(Map<String, Object> model,Model m,HttpSession sess)
	{
		String userid = SecurityContextHolder.getContext().getAuthentication().getName();
		
		System.out.println("user:"+userid);
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		System.out.println("Authorities:"+authorities);
		
		for (GrantedAuthority authority : authorities) {
			if(authority.getAuthority().equals("ROLE_USER")){
				lg.setSignIn("Log Out");
				lg.setSignUp("Sign Up");
				
				sess.setAttribute("SignIn", lg.getSignIn());
				sess.setAttribute("SignUp", lg.getSignUp());
					
				String name=reg.regDetails().getName();
				
				String id=reg.regDetails().getEmail();
				
				sess.setAttribute("userEmail", id);
				
				List<CartDetails> cartlist=cart.getList(id);
				
				Object[] total=cart.totalPrice(reg.regDetails().getEmail()).toArray();
				sess.setAttribute("total",total[0]);
				
				sess.setAttribute("Cart", cartlist);
				sess.setAttribute("size",cartlist.size());
				sess.setAttribute("username","Welcome "+name);
			}
			
		}
		
		/*if(reg.isValidUser(l) != null)
			{
		
			
			
			if(reg.regDetails().getRole().equals("admin"))
			{
				m.addAttribute("onclickAdminHome",1);
				return "AdminHome";
				}else{
					m.addAttribute("toHome",1);
					m.addAttribute("error",true);
					return "index";
				}//end if-else for role validation
		}//end validation
		else{
			System.out.println("Error text!");
			m.addAttribute("onclicklogin",1);
			m.addAttribute("error",true);
			return "index";*/
			
		return "index";
		}//end login
	}