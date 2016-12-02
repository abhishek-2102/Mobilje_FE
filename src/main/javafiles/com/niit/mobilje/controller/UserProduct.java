package com.niit.mobilje.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.mobilje.appconfig.DescpText;
import com.niit.mobilje.dao.ProductDao;
import com.niit.mobilje.trans.ProductDetails;

@Controller
public class UserProduct {
	
	@Autowired
	ProductDao prod;
	
	@RequestMapping(value="/product",method=RequestMethod.GET)
	public String dispProduct(@RequestParam("cid") String cid,Model m)
	{	
		m.addAttribute("userProduct",1);
	System.out.println("Category Products");
		List<String> prod=this.prod.dispProduct(cid);
		m.addAttribute("pData",prod);
		
		return "index";
	}
	
	@RequestMapping(value="/product",method=RequestMethod.POST)
	public String dispSearch(@RequestParam("search") String src,Model m)
	{	
		List<ProductDetails> pr=this.prod.searchProd(src);
		
		if(pr.isEmpty()){
			m.addAttribute("toHome",1);
			m.addAttribute("searchText","Search Not Found");
		}
		else{
			m.addAttribute("userProduct",1);
			m.addAttribute("pData",pr);
		}
		return "index";
	}
	
	@RequestMapping(value="/indivProdDisp")
	public String dispIndiv(@RequestParam("pid") String pid,Model m,Map<String,Object> map)
	{	
		
		String display=DescpText.DisplText(pid);
		
		if(display!=null){
			m.addAttribute("description",display);
		}
		else{
			m.addAttribute("description","Description comming soon");
		}
		
		m.addAttribute("indivProduct",1);
		List<String> prod=this.prod.dispIndiv(pid);
		m.addAttribute("indivData",prod);
		return "index";
	}
}
