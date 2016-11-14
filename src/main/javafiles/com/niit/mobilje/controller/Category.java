package com.niit.mobilje.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.mobilje.dao.CategoryDao;
import com.niit.mobilje.trans.CategoryDetails;


@Controller
@Transactional
@RequestMapping(value="categoryPage")
public class Category {

		@Autowired
		CategoryDao cat;
		@RequestMapping(method = RequestMethod.GET)
		public String viewCatPage(Map<String,Object> model,Model m)
		{
			m.addAttribute("onclickCategory",1);
			CategoryDetails cat= new CategoryDetails();
			model.put("cat_form",cat);
			return "AdminHome";
		}//end get

		@RequestMapping(method = RequestMethod.POST)
		public String prosReg(@ModelAttribute("cat_form") CategoryDetails c, Map<String,Object> model,Model m)
		{
				m.addAttribute("onclickCat",1);
				cat.saveCategory(c);
				System.out.println("Data received");
				return "AdminHome";
		}//end post
		
}//end class
