package com.niit.mobilje.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.mobilje.dao.SupplierDao;
import com.niit.mobilje.trans.SupplierDetails;

@Controller
@Transactional
@RequestMapping(value="supplierPage")
public class Supplier {
	
	@Autowired
	SupplierDao sup;
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewCatPage(Map<String,Object> model,Model m)
	{
		m.addAttribute("onclickSupplier",1);
		SupplierDetails sup= new SupplierDetails();
		model.put("sup_form",sup);
		String supData = this.sup.supList(new SupplierDetails()); // instance
		System.out.println(supData);
		m.addAttribute("supData", supData);
				
		return "AdminHome";
	}//end get

	@RequestMapping(method = RequestMethod.POST)
	public String prosReg(@ModelAttribute("sup_form") SupplierDetails s, Map<String,Object> model,Model m)
	{
			
			if(sup.saveSupplier(s))
			{	
				System.out.println("Data received");
				m.addAttribute("supMessage", "Supplier entred succesfully");
				m.addAttribute("entry", true);
				String supData = this.sup.supList(new SupplierDetails()); // instance
				System.out.println(supData);
				m.addAttribute("supData", supData);
				m.addAttribute("onclickSup",1);
				return "AdminHome";
			}				
			else
			{
				m.addAttribute("onclickCat", 1);
				m.addAttribute("supMessage", "Supplier error");
				m.addAttribute("error", true);
				String supData = this.sup.supList(new SupplierDetails()); // instance
				System.out.println(supData);
				m.addAttribute("supData", supData);
				m.addAttribute("onclickSup",1);
				System.out.println("Data received");
				return "AdminHome";
			}
	}//end post
}
