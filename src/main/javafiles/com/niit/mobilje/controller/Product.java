package com.niit.mobilje.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.mobilje.dao.ProductDao;
import com.niit.mobilje.trans.CategoryDetails;
import com.niit.mobilje.trans.ProductDetails;
import com.niit.mobilje.trans.SupplierDetails;

@Controller
@Transactional
@RequestMapping(value="productPage")
public class Product {
	
	@Autowired
	ProductDao prod;
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewCatPage(Map<String,Object> model,Model m)
	{
		m.addAttribute("onclickProduct",1);
		ProductDetails prod= new ProductDetails();
		model.put("prod_form",prod);
		String cateData=this.prod.categoryList(new CategoryDetails());  //instance variable
		String supData=this.prod.supplierList(new SupplierDetails());  //instance variable
		m.addAttribute("categoryData",cateData);
		m.addAttribute("supplierData",supData);
		return "AdminHome";
	}//end get

	@RequestMapping(method = RequestMethod.POST)
	public String prosReg(@ModelAttribute("prod_form") ProductDetails p, Map<String,Object> model,Model m)
	{
			m.addAttribute("onclickProd",1);
			prod.saveProduct(p);
			System.out.println("Data received");
			return "AdminHome";
	}//end post
}
