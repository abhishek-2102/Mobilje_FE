package com.niit.mobilje.dao;

import com.niit.mobilje.trans.CategoryDetails;

public interface CategoryDao {
	public boolean saveCategory(CategoryDetails cat);
	public boolean deleteCategory(String cid);
	public CategoryDetails getCategory(String cid);
	public boolean updateCategory(CategoryDetails c);
	
	public String catList(CategoryDetails c);
	
}
