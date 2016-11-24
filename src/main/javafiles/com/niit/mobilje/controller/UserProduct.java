package com.niit.mobilje.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.mobilje.dao.ProductDao;

@Controller
public class UserProduct {
	
	@Autowired
	ProductDao prod;
	
	@RequestMapping(value="/product")
	public String dispProduct(@RequestParam("cid") String cid,Model m,Map<String,Object> map)
	{	
		m.addAttribute("userProduct",1);
		List<String> prod=this.prod.dispProduct(cid);
		System.out.println("prod to display"+prod);
		m.addAttribute("pData",prod);
		return "index";
	}
}
