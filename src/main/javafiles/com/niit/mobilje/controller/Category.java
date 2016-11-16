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
@RequestMapping(value = "categoryPage")
public class Category {

	@Autowired
	CategoryDao cat;

	@RequestMapping(method = RequestMethod.GET)
	public String viewCatPage(Map<String, Object> model, Model m) {
		m.addAttribute("onclickCategory", 1);
		CategoryDetails cat = new CategoryDetails();
		model.put("cat_form", cat);
		String cateData = this.cat.catList(new CategoryDetails()); // instance
		System.out.println(cateData);
		m.addAttribute("catData", cateData);
		return "AdminHome";
	}// end get

	@RequestMapping(method = RequestMethod.POST)
	public String prosReg(@ModelAttribute("cat_form") CategoryDetails c, Map<String, Object> model, Model m) {

	if (cat.saveCategory(c)) {
			System.out.println("Data received");
			m.addAttribute("onclickCat", 1);
			m.addAttribute("catMessage", "Category entred succesfully");
			m.addAttribute("entry", true);
			String cateData = this.cat.catList(new CategoryDetails()); // instance
			m.addAttribute("catData", cateData);
			return "AdminHome";
		} 
		
		else {
			m.addAttribute("onclickCat", 1);
			m.addAttribute("catMessage", "Something went wrong");
			m.addAttribute("error", true);
			String cateData = this.cat.catList(new CategoryDetails()); // instance
			m.addAttribute("catData", cateData);
			return "AdminHome";
		}
	}// end post

}// end class
