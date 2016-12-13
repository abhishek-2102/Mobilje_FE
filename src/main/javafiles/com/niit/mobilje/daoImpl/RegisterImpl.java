package com.niit.mobilje.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.mobilje.dao.RegisterDao;
import com.niit.mobilje.trans.LoginDetails;
import com.niit.mobilje.trans.Register;

@Repository
@Transactional
public class RegisterImpl implements RegisterDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	String r;
	
	String name;
	
	Register reg;
	
	public RegisterImpl(SessionFactory sess) {
		super();
		this.sessionFactory=sess;
	}

	public boolean saveRegister(Register user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			System.out.println("Sent");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error");
			return false;
		}
	}
	
	public Register isValidUser(LoginDetails log) {
		
		String email=log.getLogin_email();
		String password=log.getLogin_password();
		
		Query query=sessionFactory.getCurrentSession().createQuery("from Register where email='"+email+"' and password='"+password+"'");
		/*query.setParameter("e", email);
		query.setParameter("p", password);*/
		@SuppressWarnings("unchecked")
		List<Register> reg=query.list();
		
		if(reg!=null){
			for(Register r:reg){
				this.reg=r;
			}
		}
		return this.reg;
	}
	
	public Register regDetails(){
		return reg;
	}
}
