package com.niit.mobilje.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.niit.mobilje.dao.OrderDao;
import com.niit.mobilje.trans.BillingAddress;
import com.niit.mobilje.trans.OrderDetails;
import com.niit.mobilje.trans.ShippingAddress;

@Component
public class CheckOutFlow {
	
	@Autowired
	OrderDao orderdao;
	
	/*@Autowired
	HttpSession session;
	*/
	
	String email;
	
	
	
	/*public CheckOutFlow(HttpSession sess) {
		super();
		this.session=sess;
	}*/


	public OrderDetails orderSet(){
		return new OrderDetails();
	}//end order set
		
	
	public String shippAddr(OrderDetails order,ShippingAddress ship){
		Gson g=new Gson();
		String shipping=g.toJson(ship);
		
		order.setShipping(shipping);
		
		return "shipsave";
	}//end set shipping address
	
	public String billAddr(OrderDetails order,BillingAddress bill){
		this.email=bill.getUserid();
		Gson g=new Gson();
		String billing=g.toJson(bill);
		
		Date d = new Date( );
	    SimpleDateFormat fmt=new SimpleDateFormat ("yyyy.MM.dd");
	    String date= fmt.format(d);
		
	    String uID = UUID.randomUUID().toString();
		
		order.setDate(date);
		order.setId(uID);
		order.setBilling(billing);
		order.setU_id(bill.getUserid());
		
		System.out.println(order);
		this.orderdao.saveOrder(order);
		
		return "billsave";
	}//end set billing
	
	public void setInSession(){
		
	}
	
	public String orderdisp(){
		
		return "order";
	}
}
