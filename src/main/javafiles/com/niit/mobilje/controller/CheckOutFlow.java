package com.niit.mobilje.controller;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.niit.mobilje.trans.BillingAddress;
import com.niit.mobilje.trans.OrderDetails;
import com.niit.mobilje.trans.ShippingAddress;

@Component
public class CheckOutFlow {
	
	public OrderDetails orderSet(){
		return new OrderDetails();
	}//end order set
	
	public String userSet(){
		
		return null;
	}
	
	public String shippAddr(OrderDetails order,ShippingAddress ship){
		Gson g=new Gson();
		String shipping=g.toJson(ship);
		order.setShipping(shipping);
		return "shipsave";
	}//end set shipping address
	
	public String billAddr(OrderDetails order,BillingAddress bill){
		Gson g=new Gson();
		String billing=g.toJson(bill);
		order.setBilling(billing);
		return "billsave";
	}//end set billing
	
	public String billView(){
		
		
		return "orderview";
	}
}
