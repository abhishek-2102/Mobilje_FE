package com.niit.mobilje.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.niit.mobilje.dao.CategoryDao;
import com.niit.mobilje.trans.CategoryDetails;

@Repository
@Transactional
public class CategoryImpl implements CategoryDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public CategoryImpl(SessionFactory sess){
		super();
		this.sessionFactory=sess;
		
	}//end constructor
	
	public boolean saveCategory(CategoryDetails cat)
	{
	try {
		sessionFactory.getCurrentSession().save(cat);
		return true;
	} //end try
	catch (HibernateException e) {

		e.printStackTrace();
		return false;
	}//end catch
	}//end saveCat

	public String categoryList(CategoryDetails c) {
		@SuppressWarnings("unchecked")
		List<CategoryDetails> catList = sessionFactory.getCurrentSession().createCriteria(CategoryDetails.class).list();
		Gson gson= new Gson();
		String cat_list = gson.toJson(catList);
		return cat_list;
	}
	
}//end impl
