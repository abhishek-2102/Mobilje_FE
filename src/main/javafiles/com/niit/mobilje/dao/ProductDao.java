package com.niit.mobilje.dao;

import java.util.List;

import com.niit.mobilje.trans.CategoryDetails;
import com.niit.mobilje.trans.ProductDetails;
import com.niit.mobilje.trans.SupplierDetails;

public interface ProductDao {
	//crud operations
	public boolean saveProduct(ProductDetails prod);
	public boolean deleteProduct(String pid);
	public ProductDetails getProduct(String pid);
	public boolean updateProduct(ProductDetails p);
	
	//display category dropdown in the admin page
	public String categoryList(CategoryDetails c);
	
	//display supplier dropdown in the admin page
	public String supplierList(SupplierDetails s);

	//display product list in admin page
	public String productList(ProductDetails p);
	
	//display products to user according to the category selected
	public List<String> dispProduct(String id);
	
	//display individual products
	public List<String> dispIndiv(String id);
}
