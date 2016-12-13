package com.niit.mobilje.trans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="orders")
@Component
public class OrderDetails implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@Column
	private String shipping;
	
	@Column
	private String billing;
	
	@Column
	private String u_id;
	
	@Column
	private String date;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getShipping() {
		return shipping;
	}

	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

	public String getBilling() {
		return billing;
	}

	public void setBilling(String billing) {
		this.billing = billing;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
