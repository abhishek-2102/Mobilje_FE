package com.niit.mobilje.dao;

import java.util.List;

import com.niit.mobilje.trans.CartDetails;

public interface CartDao {
	//add to cart
	public boolean addtoCart(CartDetails cart);
	//get from cart table
	public List<CartDetails> getList(String username);
	//update quantity
	public void upQuant(int q,String ctid);
	//delete quantity
	public void deleteCart(String id);
	
	public List<String> totalPrice(String uid);
}
