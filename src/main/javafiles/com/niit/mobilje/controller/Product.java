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

import com.niit.mobilje.dao.ProductDao;
import com.niit.mobilje.trans.CategoryDetails;
import com.niit.mobilje.trans.ProductDetails;
import com.niit.mobilje.trans.SupplierDetails;

@Controller
@Transactional
public class Product {
	
	@Autowired
	ProductDao prod;
	
	@RequestMapping(value="productPage",method = RequestMethod.GET)
	public String viewCatPage(Map<String,Object> model,Model m)
	{
		m.addAttribute("onclickProduct",1);
		ProductDetails prod= new ProductDetails();
		model.put("prod_form",prod);
		String cateData=this.prod.categoryList(new CategoryDetails());  //instance variable
		String supData=this.prod.supplierList(new SupplierDetails());  //instance variable
		String prodData=this.prod.productList(new ProductDetails());  //instance variable
		
		m.addAttribute("categoryData",cateData);
		m.addAttribute("supplierData",supData);
		m.addAttribute("productData",prodData);
		return "AdminHome";
	}//end get

	@RequestMapping(value="productPage", method = RequestMethod.POST)
	public String prosReg(@ModelAttribute("prod_form") ProductDetails p, Map<String,Object> model,Model m)
	{
			if(prod.saveProduct(p))
			{
				m.addAttribute("onclickProduct",1);
				m.addAttribute("proMessage", "Product entred succesfully");
				m.addAttribute("entry", true);
				
				String cateData=this.prod.categoryList(new CategoryDetails());  //instance variable
				String supData=this.prod.supplierList(new SupplierDetails());  //instance variable
				String prodData=this.prod.productList(new ProductDetails());  //instance variable
	
				m.addAttribute("categoryData",cateData);
				m.addAttribute("supplierData",supData);
				m.addAttribute("productData",prodData);
				
				return "AdminHome";
			}
			else
			{			
				m.addAttribute("proMessage", "Error");
				m.addAttribute("error", true);
				m.addAttribute("onclickProduct",1);
				String cateData=this.prod.categoryList(new CategoryDetails());  //instance variable
				String supData=this.prod.supplierList(new SupplierDetails());  //instance variable
				String prodData=this.prod.productList(new ProductDetails());  //instance variable

				m.addAttribute("categoryData",cateData);
				m.addAttribute("supplierData",supData);
				m.addAttribute("productData",prodData);
	
				System.out.println("Data received");
				return "AdminHome";	
			}
	}//end post
	
	@RequestMapping(value="/deleteProd", method=RequestMethod.GET)
	public String deleteProd(@RequestParam("pid") String pid,Model m)
	{	
		m.addAttribute("onclickProduct",1);
		
		m.addAttribute("message","Product Deleted");
		m.addAttribute("delete",true);
		String cateData=this.prod.categoryList(new CategoryDetails());  //instance variable
		String supData=this.prod.supplierList(new SupplierDetails());  //instance variable
		String prodData=this.prod.productList(new ProductDetails());  //instance variable
		m.addAttribute("categoryData",cateData);
		m.addAttribute("supplierData",supData);
		m.addAttribute("productData",prodData);
		System.out.println("Deleted Entry");
		this.prod.deleteProduct(pid);
		return "AdminHome";
	}
}
