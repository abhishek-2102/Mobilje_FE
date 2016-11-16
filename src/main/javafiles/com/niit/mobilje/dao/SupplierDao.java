package com.niit.mobilje.dao;

import com.niit.mobilje.trans.SupplierDetails;

public interface SupplierDao {
	public boolean saveSupplier(SupplierDetails sup);
	public String supList(SupplierDetails s);
	public boolean deleteSupplier(SupplierDetails s);
	public SupplierDetails getSupplier(String s_id);
	
	
}
