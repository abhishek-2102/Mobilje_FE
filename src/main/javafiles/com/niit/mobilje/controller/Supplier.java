package com.niit.mobilje.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.mobilje.dao.SupplierDao;
import com.niit.mobilje.trans.SupplierDetails;

@Controller
@Transactional
public class Supplier {
	
	@Autowired
	SupplierDao sup;
	
	@RequestMapping(value="supplierPage",method = RequestMethod.GET)
	public String viewCatPage(Map<String,Object> model,Model m)
	{	
		m.addAttribute("whenSupSave", true);
		m.addAttribute("onclickSupplier",1);
		
		SupplierDetails sup= new SupplierDetails();
		model.put("sup_form",sup);
		
		String supData = this.sup.supplierList(new SupplierDetails()); // instance
		System.out.println(supData);
		m.addAttribute("supData", supData);
		
		return "AdminHome";
	}//end get

	@RequestMapping(value="supplierPage",method = RequestMethod.POST)
	public String prosReg(@ModelAttribute("sup_form") SupplierDetails s, Map<String,Object> model,Model m)
	{
		if(sup.saveSupplier(s))
		{	
			m.addAttribute("whenSupSave", true);
			System.out.println("Data received");
			
			m.addAttribute("supMessage", "Supplier entred succesfully");
			m.addAttribute("entry", true);
			
			String supData = this.sup.supplierList(new SupplierDetails()); // instance				
			System.out.println(supData);
			m.addAttribute("supData", supData);
			
			m.addAttribute("onclickSupplier",1);
			return "AdminHome";
			}				
		else
		{	
			m.addAttribute("whenSupSave", true);
			m.addAttribute("supMessage", "Supplier error");
			
			m.addAttribute("error", true);
			String supData = this.sup.supplierList(new SupplierDetails()); // instance
			System.out.println(supData);
			m.addAttribute("supData", supData);
			
			m.addAttribute("onclickSupplier",1);
			return "AdminHome";
			}
	}//end post
	
	
	@RequestMapping(value="/deleteSup", method=RequestMethod.GET)
	public String deleteSup(@RequestParam("sid") String sid,Model m,Map<String,Object> model)
	{	
		if(this.sup.deleteSupplier(sid))
		{	
			m.addAttribute("whenSupSave", true);
			m.addAttribute("onclickSupplier",1);
			m.addAttribute("supMessage", "Supplier Deleted");
			m.addAttribute("delete", true);
			SupplierDetails sup=new SupplierDetails();
			model.put("sup_form", sup);
			String supData = this.sup.supplierList(new SupplierDetails()); // instance
			m.addAttribute("supData", supData);
			System.out.println("Entry Deleted");
			return "AdminHome";
		}//end if
		
		else
		{	
			m.addAttribute("whenSupSave", true);
			m.addAttribute("onclickSupplier",1);
			
			String supData = this.sup.supplierList(new SupplierDetails()); // instance
			m.addAttribute("supData", supData);
			
			SupplierDetails sup=new SupplierDetails();
			model.put("sup_form", sup);
			
			System.out.println("Entry Deleted");
			return "AdminHome";
		}//end else
		
	}//end delete product
	
	@RequestMapping(value="/updateSup", method=RequestMethod.GET)
	public String getSupplier(@RequestParam("sid") String sid,Model m,Map<String,Object> model)
	{	
		m.addAttribute("whenSupUpdate",true);
		m.addAttribute("onclickSupplier",1);
		System.out.println(sid);
		
		String supData = this.sup.supplierList(new SupplierDetails()); // instance
		m.addAttribute("supData", supData);
		
		SupplierDetails sup=this.sup.getSupplier(sid);
		model.put("sup_form",sup);
		
		return "AdminHome";
	}
	
	@RequestMapping(value="/supUpdatePage",method=RequestMethod.POST)
	public String updateSupplier(@ModelAttribute("sup_form") SupplierDetails s, Map<String,Object> model,Model m)
	{

		if(this.sup.updateSupplier(s))
		{	
			m.addAttribute("whenSupUpdate", true);
			m.addAttribute("supMessage", "Supplier details Updated");
			m.addAttribute("update", true);
			
			String supData = this.sup.supplierList(new SupplierDetails()); // instance				
			System.out.println(supData);
			m.addAttribute("supData", supData);
			
			m.addAttribute("onclickSupplier",1);
			return "AdminHome";
			}				
		else
		{	
			m.addAttribute("whenSupSave", true);
			m.addAttribute("supMessage", "Supplier update unsucessful");
			
			m.addAttribute("update", true);
			String supData = this.sup.supplierList(new SupplierDetails()); // instance
			System.out.println(supData);
			m.addAttribute("supData", supData);
			
			m.addAttribute("onclickSupplier",1);
			return "AdminHome";
		}
	}
	
}
