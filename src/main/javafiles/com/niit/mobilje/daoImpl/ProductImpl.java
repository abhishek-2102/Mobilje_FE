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
		
		
		public ProductImpl(SessionFactory sess) 
		{
			super();
			this.sessionFactory=sess;
		}//end constructor

		public boolean saveProduct(ProductDetails prod) {
			try 
			{
				sessionFactory.getCurrentSession().save(prod);
				return true;
			} 
			
			catch (HibernateException e) 
			{
				e.printStackTrace();
				return false;
			}
			
		}//end save
		
		
		public boolean deleteProduct(String pid)
		{
			ProductDetails prod=(ProductDetails) sessionFactory.getCurrentSession().get(ProductDetails.class,pid);
			sessionFactory.getCurrentSession().delete(prod);
			return true;
		}//end delete
		
		public ProductDetails getProduct(String pid) 
		{
			
			return (ProductDetails) sessionFactory.getCurrentSession().get(ProductDetails.class, pid);
		}//end get
		
		public boolean updateProduct(ProductDetails p) 
		{
			try {
				sessionFactory.getCurrentSession().update(p);
				return true;
			} catch (HibernateException e) {
				e.printStackTrace();
				return false;
			}	
		}//end update
		
		public String categoryList(CategoryDetails c) 
		{
			@SuppressWarnings("unchecked")
			List<CategoryDetails> catList = sessionFactory.getCurrentSession().createCriteria(CategoryDetails.class).list();
			Gson gson= new Gson();
			String cat_list = gson.toJson(catList);
			return cat_list;
		}//end category list
		
		
		public String supplierList(SupplierDetails s) 
		{
			@SuppressWarnings("unchecked")
			List<CategoryDetails> supList = sessionFactory.getCurrentSession().createCriteria(SupplierDetails.class).list();
			Gson gson= new Gson();
			String sup_list = gson.toJson(supList);
			return sup_list;
		}//end supplier list
		
		public String productList(ProductDetails p) {
				@SuppressWarnings("unchecked")
			List<ProductDetails> prodList = sessionFactory.getCurrentSession().createCriteria(ProductDetails.class).list();
			Gson gson=new Gson();
			String prod_list=gson.toJson(prodList);
			System.out.println(prod_list);
			return prod_list;
		}//end product list

		public String dispProduct(String id) {
			
			
			
			
			return null;
		}
}
