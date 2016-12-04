package com.niit.mobilje.trans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="cart")
@Component
public class CartDetails {

	@Id
	private String ct_id;
	
	@Column
	private String p_id;
	
	@Column
	private String u_id;
	
	@Column
	private int quantity;
	
	@Column
	private int price;
	
	@Column
	private String date;

	@Column
	private String p_name;
	
	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getCt_id() {
		return ct_id;
	}

	public void setCt_id(String ct_id) {
		this.ct_id = ct_id;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
