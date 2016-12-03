package com.niit.mobilje.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mobilje.dao.CartDao;
import com.niit.mobilje.trans.CartDetails;


@Repository
@Transactional
public class CartImpl implements CartDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public CartImpl(SessionFactory sess) {
		super();
		this.sessionFactory=sess;
	}
	
	public boolean addtoCart(CartDetails cart) {
		
	    sessionFactory.getCurrentSession().saveOrUpdate(cart);
	    
	    return true;
	}

	public List<CartDetails> getList() {
		
		return null;
	}
	
	
}
