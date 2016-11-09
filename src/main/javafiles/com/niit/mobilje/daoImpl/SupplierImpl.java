package com.niit.mobilje.daoImpl;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mobilje.dao.SupplierDao;
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

	public boolean saveSupplier(SupplierDetails sup) {
		try {
			sessionFactory.getCurrentSession().save(sup);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}//end try catch
		
	}//end save Supp

}
