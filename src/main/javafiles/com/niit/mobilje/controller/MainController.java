package com.niit.mobilje.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.mobilje.dao.CategoryDao;
import com.niit.mobilje.trans.CategoryDetails;


@Controller
public class MainController {
	
	@Autowired
	CategoryDao cat;
	
	@Autowired
	CategoryDetails c;
	
	@RequestMapping("/")
	public String gotohome(Model m,HttpSession sess)
	{	
		
		String cList=cat.catList(c);      
		sess.setAttribute("categoryData", cList); //send list to jsp
		return "index";
	}
	
	@RequestMapping("/home")
	public String gotoindex(Model m)
	{
		m.addAttribute("onclickhome",1);
		return "index";
	}
	
	@RequestMapping("/adminHome")
	public String gotoadmin(Model m)
	{
		m.addAttribute("onclickAdminHome",1);
		return "AdminHome";
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
