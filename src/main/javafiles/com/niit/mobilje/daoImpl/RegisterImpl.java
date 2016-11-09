package com.niit.mobilje.daoImpl;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.mobilje.dao.RegisterDao;
import com.niit.mobilje.trans.RegisterDetails;

@Repository
public class RegisterImpl implements RegisterDao {
	
	@Autowired
	SessionFactory sf;
	
	public RegisterImpl(SessionFactory sess) {
		super();
		this.sf=sess;
	}

	public boolean saveRegister(RegisterDetails user) {
		try {
			sf.openSession().save(user);
			System.out.println("Sent");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error");
			return false;
		}
	}
	
	

	
}
