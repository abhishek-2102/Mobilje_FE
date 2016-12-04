package com.niit.mobilje.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.mobilje.appconfig.DescpText;
import com.niit.mobilje.dao.CartDao;
import com.niit.mobilje.dao.ProductDao;
import com.niit.mobilje.dao.RegisterDao;
import com.niit.mobilje.trans.CartDetails;
import com.niit.mobilje.trans.LoginDetails;
import com.niit.mobilje.trans.ProductDetails;

@Controller
public class UserProduct {
	
	@Autowired
	ProductDao prod;
	
	@Autowired
	CartDao cart;
	
	@Autowired
	RegisterDao reg;
	
	@RequestMapping(value="/product",method=RequestMethod.GET)
	public String dispProduct(@RequestParam("cid") String cid,Model m)
	{	
		m.addAttribute("userProduct",1);
		
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
	public String dispIndiv(@RequestParam("pid")String pid, Model m,Map<String,Object> map)
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
	}//end displaying individual 
	
	@RequestMapping(value="/tocart")
	public String dispCartPage(@RequestParam("pid") String pid,@RequestParam("pname") String prodname,Model m,HttpSession sess,Map<String, Object> model){
		
		if(sess.getAttribute("username").equals(" ")){
			System.out.println("No email Id");
			m.addAttribute("cartText",true);
			m.addAttribute("onclicklogin",1);
			LoginDetails login = new LoginDetails();
			model.put("login_form",login);
			
		}//end if
		
		else{
			Date d = new Date( );
		    SimpleDateFormat fmt=new SimpleDateFormat ("yyyy.MM.dd");
		    String date= fmt.format(d);
			
		    ProductDetails p=prod.getProduct(pid);
		    
			int q=1;
			
		    int iP=p.getP_price();
		    int price=q*iP;
		    
		    CartDetails cat=new CartDetails();
			String uID = UUID.randomUUID().toString();
			
			cat.setCt_id(uID);
			cat.setDate(date);
			cat.setP_id(p.getP_id());
			cat.setQuantity(q);
			cat.setU_id(reg.regDetails().getEmail());
			cat.setPrice(price);
			cat.setP_name(prodname);
			
			cart.addtoCart(cat);
			
			List<CartDetails> cartlist=cart.getList(reg.regDetails().getEmail());
			sess.setAttribute("Cart", cartlist);
			
			int size=cartlist.size();
			sess.setAttribute("Size",size );
			
			m.addAttribute("userProduct",1);
		}//end else
		return "index";
	}//add to cart
	
	@RequestMapping("/tocartdisp")
	public String displayCart(@RequestParam("username") String username,Model m){
		
		@SuppressWarnings("unused")
		List<CartDetails> cartlist=cart.getList(username);
		
		m.addAttribute("oncartDisp",1);
		return "index";
	}//display cart
}
