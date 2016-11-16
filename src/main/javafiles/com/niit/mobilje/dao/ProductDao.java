package com.niit.mobilje.dao;

import com.niit.mobilje.trans.CategoryDetails;
import com.niit.mobilje.trans.ProductDetails;
import com.niit.mobilje.trans.SupplierDetails;

public interface ProductDao {
	
	public boolean saveProduct(ProductDetails prod);
	public boolean deleteProduct(String pid);
	public ProductDetails getProduct(String pid);
	public boolean updateProduct(ProductDetails p);
	
	public String categoryList(CategoryDetails c);
	
	public String supplierList(SupplierDetails s);

	public String productList(ProductDetails p);
}
