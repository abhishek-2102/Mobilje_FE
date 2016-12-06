package com.niit.mobilje.daoImpl;

import java.util.List;

import org.hibernate.Query;
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
	
	//constructor
	public CartImpl(SessionFactory sess) {
		super();
		this.sessionFactory=sess;
	}
	
	//add to cart
	public boolean addtoCart(CartDetails cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
	    return true;
	}
	
	//get cart list to view
	public List<CartDetails> getList(String username) {
		
		String hql="from CartDetails where u_id='"+username+"'";
		Query que=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<CartDetails> cartl=que.list();
		return cartl;
	}

	//update quantity in the table
	public void upQuant(int q,String ctid) {
		CartDetails cart=(CartDetails)sessionFactory.getCurrentSession().get(CartDetails.class, ctid);
		int price=cart.getPrice();
		
		cart.setQuantity(q);
		cart.setPrice(q*price);
		sessionFactory.getCurrentSession().update(cart);
	}
	
	//delete product from cart table
	public void deleteCart(String id){
		System.out.println("Delete Process");
		CartDetails cart=(CartDetails)sessionFactory.getCurrentSession().get(CartDetails.class, id);
		
		sessionFactory.getCurrentSession().delete(cart);
		System.out.println("Product deleted from cart");
	}
}
