package com.niit.mobilje.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.mobilje.dao.CategoryDao;
import com.niit.mobilje.trans.CategoryDetails;

@Controller
public class Category {

	@Autowired
	CategoryDao cat;

	@RequestMapping(value = "categoryPage",method = RequestMethod.GET)
	public String viewCatPage(Map<String, Object> model, Model m) {
		m.addAttribute("whenCatSave",true);
		m.addAttribute("onclickCategory", 1);
		
		CategoryDetails cat = new CategoryDetails();
		model.put("cat_form", cat);
		
		String cateData = this.cat.catList(new CategoryDetails()); // instance
		m.addAttribute("catData", cateData);
		
		return "AdminHome";
	}// end get

	@RequestMapping(value = "categoryPage",method = RequestMethod.POST)
	public String prosReg(@ModelAttribute("cat_form") CategoryDetails c, Map<String, Object> model, Model m) {

		if (this.cat.saveCategory(c)) 
		{	
			m.addAttribute("whenCatSave",true);
			
			m.addAttribute("onclickCategory", 1);
			
			m.addAttribute("catMessage", "Category entred succesfully");
			m.addAttribute("entry", true);
			
			String cateData = this.cat.catList(new CategoryDetails()); // instance
			m.addAttribute("catData", cateData);
			
			return "AdminHome";
		} 
		
		else 
		{	
			
			m.addAttribute("whenCatSave",true);
			m.addAttribute("onclickCategory", 1);
			
			m.addAttribute("catMessage", "Something went wrong");
			m.addAttribute("error", true);
			
			String cateData = this.cat.catList(new CategoryDetails()); // instance
			m.addAttribute("catData", cateData);
			
			return "AdminHome";
		}
	}// end post
	
	@RequestMapping(value="/deleteCat",method=RequestMethod.GET)
	public String deleteCat(@RequestParam("cid") String cid,Model m,Map<String,Object> model)
	{
		if(this.cat.deleteCategory(cid))
		{
			m.addAttribute("whenCatSave",true);
			m.addAttribute("onclickCategory",1);
			
			m.addAttribute("catMessage", "Category Deleted successfully");
			m.addAttribute("delte",true);
			
			String cateData = this.cat.catList(new CategoryDetails()); // instance
			m.addAttribute("catData", cateData);
			
			CategoryDetails cat = new CategoryDetails();
			model.put("cat_form", cat);
			
			return "AdminHome";
		}
		else
		{
			m.addAttribute("whenCatSave",true);
			
			m.addAttribute("onclickCategory",1);
			m.addAttribute("catMessage", "Category Not");
			m.addAttribute("delte",true);
			
			String cateData = this.cat.catList(new CategoryDetails()); // instance
			m.addAttribute("catData", cateData);
			
			CategoryDetails cat = new CategoryDetails();
			model.put("cat_form", cat);
			
			return "AdminHome";
		}//end else
	}//end delete category
	
	@RequestMapping(value="/updateCat",method=RequestMethod.GET)
	public String getCat(@RequestParam("cid") String cid,Model m,Map<String,Object> model)
		{	
			m.addAttribute("whenCatUpdate",true);
			
			m.addAttribute("onclickCategory",1);
			System.out.println(cid);
			
			String cateData = this.cat.catList(new CategoryDetails()); // instance
			m.addAttribute("catData", cateData);
			
			CategoryDetails cat=this.cat.getCategory(cid);
			model.put("cat_form",cat);
			
			return "AdminHome";
		
		}//end get cat
	
	@RequestMapping(value="/cateUpdatePage",method=RequestMethod.POST)
	public String updateCat(@ModelAttribute("cat_form") CategoryDetails c, Map<String, Object> model, Model m) {

		if (this.cat.updateCategory(c)) 
		{	
			m.addAttribute("whenCatUpdate",true);
			
			m.addAttribute("onclickCategory", 1);
			
			m.addAttribute("catMessage", "Category updated succesfully");
			m.addAttribute("update", true);
			
			String cateData = this.cat.catList(new CategoryDetails()); // instance
			m.addAttribute("catData", cateData);
			
			return "AdminHome";
		} 
		else 
		{
			m.addAttribute("whenCatUpdate",true);
			
			m.addAttribute("onclickCategory", 1);
			
			m.addAttribute("catMessage", "Something went wrong");
			m.addAttribute("update", false);
			
			String cateData = this.cat.catList(new CategoryDetails()); // instance
			m.addAttribute("catData", cateData);
			
			return "AdminHome";
		}	//end else
	}//end update
}// end class
