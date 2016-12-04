package com.niit.mobilje.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value="/login_page")
public class Login {
	
	@Autowired
	RegisterDao reg;
	
	@Autowired
	LoginVals lg;
	
	@Autowired
	CartDao cart;
	
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
		
		sess.setAttribute("Cart","null");
		
		sess.setAttribute("size","0");
		
		return"index";
	}
	
	@RequestMapping(method =RequestMethod.POST)
	public String perfLogin(@ModelAttribute("login_form") LoginDetails l,Map<String, Object> model,Model m,HttpSession sess)
	{
		if(reg.isValidUser(l))
			{
			lg.setSignIn("Log Out");
			lg.setSignUp("Sign Up");
				
			sess.setAttribute("SignIn", lg.getSignIn());
			sess.setAttribute("SignUp", lg.getSignUp());
				
			String name=reg.regDetails().getName();
			
			String id=reg.regDetails().getEmail();
			
			sess.setAttribute("userEmail", id);
			
			List<CartDetails> cartlist=cart.getList(id);
			
			sess.setAttribute("Cart", cartlist);
			
			sess.setAttribute("size",cartlist.size());
			
			sess.setAttribute("username","Welcome "+name);
			
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
			m.addAttribute("onclicklogin",1);
			m.addAttribute("error",true);
			m.addAttribute("logError","Username and password do not match");
			return "index";
			}
		}//end login
	}

