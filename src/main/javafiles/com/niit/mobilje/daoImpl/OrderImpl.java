package com.niit.mobilje.daoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mobilje.dao.OrderDao;
import com.niit.mobilje.trans.OrderDetails;

@Repository
@Transactional
public class OrderImpl implements OrderDao {

	@Autowired
	SessionFactory sess;
	
	
	
	public OrderImpl(SessionFactory s) {
		super();
		this.sess=s;
	}

	public String saveOrder(OrderDetails order) {
		
		sess.getCurrentSession().save(order);
		
		return null;
	}

}
