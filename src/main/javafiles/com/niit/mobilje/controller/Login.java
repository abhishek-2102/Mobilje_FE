package com.niit.mobilje.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.mobilje.dao.CartDao;
import com.niit.mobilje.dao.CategoryDao;
import com.niit.mobilje.dao.RegisterDao;
import com.niit.mobilje.trans.CartDetails;
import com.niit.mobilje.trans.CategoryDetails;
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
	
	@Autowired
	CategoryDao cat;
	
	@Autowired
	CategoryDetails c;
	
	@RequestMapping(value="/login_page")
	public String viewLoginPage(Map<String, Object> model,Model m,HttpSession sess,HttpServletRequest req,HttpServletResponse res)
	{	
		
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		new SecurityContextLogoutHandler().logout(req, res, auth);
		
		sess=req.getSession(true);
		
		lg.setSignIn("Sing In");
		lg.setSignUp("Sign Up");
		
		String cList=cat.catList(c);
		sess.setAttribute("categoryData", cList);
		
		sess.setAttribute("username"," ");
		
		sess.setAttribute("SignIn", lg.getSignIn());
		sess.setAttribute("SignUp", lg.getSignUp());
		
		m.addAttribute("onclicklogin",1);
		
		/*LoginDetails login = new LoginDetails();*/
		/*model.put("login_form",login);*/
		
		sess.setAttribute("Cart","null");
		
		sess.setAttribute("size","0");
		
		return"index";
	}
	
	@RequestMapping(value="/login_success",method =RequestMethod.POST)
	public String perfLogin(@RequestParam("login_email")String login,@RequestParam("login_password") String password,Map<String, Object> model,Model m,HttpSession sess)
	{
		LoginDetails log=new LoginDetails();
		
		log.setLogin_email(login);
		log.setLogin_password(password);
		
		reg.isValidUser(log);
		
		String userid = SecurityContextHolder.getContext().getAuthentication().getName();
		
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		
		System.out.println("Authorities:"+authorities);
		System.out.println("user:"+userid);
		
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
				m.addAttribute("toHome",1);
				m.addAttribute("error",true);
			}else if(authority.getAuthority().equals("ROLE_ADMIN")){
				m.addAttribute("onclickAdminHome",1);
				return "AdminHome";				
			}
			else{
				System.out.println("error");
			}
		}//end for loop
		return "index";
		}//end login
	}