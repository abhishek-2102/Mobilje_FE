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
	
	String cid;
	
	@RequestMapping(value="/product",method=RequestMethod.GET)
	public String dispProduct(@RequestParam("cid") String cid,Model m)
	{	
		m.addAttribute("userProduct",1);
		this.cid=cid;
		List<String> prod=this.prod.dispProduct(this.cid);
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
		
		@SuppressWarnings("unchecked")
		List<CartDetails> cartList = (List<CartDetails>) sess.getAttribute("Cart");
		
		if(sess.getAttribute("username").equals(" ")){
			System.out.println("No email Id");
			m.addAttribute("cartText",true);
			m.addAttribute("onclicklogin",1);
			LoginDetails login = new LoginDetails();
			model.put("login_form",login);
			
		}//end if
		
		else{
			for(CartDetails c:cartList){
				System.out.println(c);
				if(c.getP_id().equals(pid)&&c.getU_id().equals(reg.regDetails().getEmail())){
					System.out.println("Pid:"+c.getP_id());
					System.out.println("Email:"+c.getU_id());
					m.addAttribute("oncartDisp",1);
					m.addAttribute("dupMessage",true);
					
					List<CartDetails> cartlist=cart.getList(reg.regDetails().getEmail());
					
					m.addAttribute("cart",cartlist);
					
					return "index";
				}//end if
			}//end enhanced for loop
			
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
			
			sess.setAttribute("size",size );
			
			m.addAttribute("pMess",true);
			
			List<String> prod=this.prod.dispProduct(this.cid);
			m.addAttribute("pData",prod);
			
			m.addAttribute("userProduct",1);
		}//end else
		return "index";
	}//add to cart
	
	@RequestMapping("/tocartdisp")
	public String displayCart(@RequestParam("username") String username,Model m){
		
		
		List<CartDetails> cartlist=cart.getList(username);
		
		m.addAttribute("cart",cartlist);
		
		m.addAttribute("oncartDisp",1);
		return "index";
	}//display cart
	
	@RequestMapping(value="/updatequant",method=RequestMethod.POST)
	public String updateQuant(int quant,String ctid,Model m){
		
		cart.upQuant(quant, ctid);
		
		List<CartDetails> cartlist=cart.getList(reg.regDetails().getEmail());
		
		m.addAttribute("cart",cartlist);
		
		m.addAttribute("oncartDisp",1);
		m.addAttribute("upMessage",true);
		return "index";
	}//end update product
	
	@RequestMapping("/deletCart")
	public String delCart(@RequestParam("ctid")String ctid,Model m,HttpSession sess){
		
		System.out.println("Cart id:"+ctid);
		
		cart.deleteCart(ctid);
		List<CartDetails> cartlist=cart.getList(reg.regDetails().getEmail());
		
		m.addAttribute("cart",cartlist);
		sess.setAttribute("size", cartlist.size());
		m.addAttribute("oncartDisp",1);
		m.addAttribute("delMessage",true);
		return "index";
	}//end delete quantity
}
