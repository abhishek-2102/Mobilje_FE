package com.niit.mobilje.dao;

import com.niit.mobilje.trans.CategoryDetails;

public interface CategoryDao {
	//crud operation
	public boolean saveCategory(CategoryDetails cat);
	public boolean deleteCategory(String cid);
	public CategoryDetails getCategory(String cid);
	public boolean updateCategory(CategoryDetails c);
	
	//display category list in admin
	public String catList(CategoryDetails c);
	
}
