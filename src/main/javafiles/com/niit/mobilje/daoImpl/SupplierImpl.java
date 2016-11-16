package com.niit.mobilje.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.niit.mobilje.dao.SupplierDao;
import com.niit.mobilje.trans.ProductDetails;
import com.niit.mobilje.trans.SupplierDetails;

@Repository
@Transactional
public class SupplierImpl implements SupplierDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public SupplierImpl(SessionFactory sess) {
		super();
		this.sessionFactory=sess;
	
	}//end constructor

	public boolean saveSupplier(SupplierDetails sup) 
	{
		try {
			sessionFactory.getCurrentSession().save(sup);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}//end try catch
		
	}//end save Supp
	
	public boolean deleteSupplier(SupplierDetails s) 
	{
		try {
			sessionFactory.getCurrentSession().delete(s);
			return true;
		}
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public SupplierDetails getSupplier(String s_id) {
		
		return (SupplierDetails) sessionFactory.getCurrentSession().get(SupplierDetails.class,s_id);
	}
	
	public String supList(SupplierDetails s) 
	{
		
		@SuppressWarnings("unchecked")
		List<ProductDetails> supList = sessionFactory.getCurrentSession().createCriteria(SupplierDetails.class).list();
		Gson gson=new Gson();
		String sup_list=gson.toJson(supList);
		return sup_list;
	
	}

	

	
}


