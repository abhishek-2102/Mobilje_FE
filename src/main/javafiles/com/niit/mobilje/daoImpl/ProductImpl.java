package com.niit.mobilje.daoImpl;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mobilje.dao.ProductDao;
import com.niit.mobilje.trans.ProductDetails;

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
}
