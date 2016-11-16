package com.niit.mobilje.dao;

import com.niit.mobilje.trans.SupplierDetails;

public interface SupplierDao {
	public boolean saveSupplier(SupplierDetails sup);
	public boolean deleteSupplier(String sid);
	public SupplierDetails getSupplier(String s_id);
	public boolean updateSupplier(SupplierDetails sup);
	
	public String supplierList(SupplierDetails s);
	
}
