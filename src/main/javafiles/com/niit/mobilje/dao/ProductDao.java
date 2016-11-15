package com.niit.mobilje.dao;

import com.niit.mobilje.trans.CategoryDetails;
import com.niit.mobilje.trans.ProductDetails;
import com.niit.mobilje.trans.SupplierDetails;

public interface ProductDao {
	
	public boolean saveProduct(ProductDetails prod);
	
	public String categoryList(CategoryDetails c);
	
	public String supplierList(SupplierDetails s);
	
}
