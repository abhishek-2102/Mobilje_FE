package com.niit.mobilje.trans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="category")
@Component
public class CategoryDetails {
	
	@Id
	private String c_id;
	
	@Column
	private String c_name;
	
	@Column
	private String c_desc;
	
	public Set<ProductDetails> product;
	
	/*@OneToMany(mappedBy="category",fetch=FetchType.EAGER)
	public Set<ProdectDetails> */
	
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_desc() {
		return c_desc;
	}
	public void setC_desc(String c_desc) {
		this.c_desc = c_desc;
	}
	
}
