package com.niit.mobilje.dao;

import com.niit.mobilje.trans.CategoryDetails;

public interface CategoryDao {
	public boolean saveCategory(CategoryDetails cat);
	
	public String catList(CategoryDetails c);
	
}
