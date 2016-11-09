package com.niit.mobilje.trans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="supplier")
@Component
public class SupplierDetails {
	
	@Id
	private String s_id;
	
	@Column
	private String s_name;
	
	@Column
	private String s_address;
	
	@Column
	private String s_email;
	
	@Column
	private String s_numb;

	
	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_address() {
		return s_address;
	}

	public void setS_address(String s_address) {
		this.s_address = s_address;
	}

	public String getS_email() {
		return s_email;
	}

	public void setS_email(String s_email) {
		this.s_email = s_email;
	}

	public String getS_numb() {
		return s_numb;
	}

	public void setS_numb(String s_numb) {
		this.s_numb = s_numb;
	}
}
