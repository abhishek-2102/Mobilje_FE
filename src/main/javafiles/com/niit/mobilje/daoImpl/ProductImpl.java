package com.niit.mobilje.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.niit.mobilje.dao.ProductDao;
import com.niit.mobilje.trans.CategoryDetails;
import com.niit.mobilje.trans.ProductDetails;
import com.niit.mobilje.trans.SupplierDetails;

@Repository
@Transactional

public class ProductImpl implements ProductDao{
	
		
		@Autowired
		SessionFactory sessionFactory;
		
		public ProductImpl(SessionFactory sess) {
			super();
			this.sessionFactory=sess;
		}

		public boolean saveProduct(ProductDetails prod) {
			try {
				sessionFactory.getCurrentSession().save(prod);
				return true;
			} catch (HibernateException e) {
				e.printStackTrace();
				return false;
			}
			
		}
		
		@Transactional
		public String categoryList(CategoryDetails c) {
			@SuppressWarnings("unchecked")
			List<CategoryDetails> catList = sessionFactory.getCurrentSession().createCriteria(CategoryDetails.class).list();
			Gson gson= new Gson();
			String cat_list = gson.toJson(catList);
			return cat_list;
		}
		
		@Transactional
		public String supplierList(SupplierDetails s) {
			@SuppressWarnings("unchecked")
			List<CategoryDetails> supList = sessionFactory.getCurrentSession().createCriteria(SupplierDetails.class).list();
			Gson gson= new Gson();
			String sup_list = gson.toJson(supList);
			return sup_list;
		}
}
