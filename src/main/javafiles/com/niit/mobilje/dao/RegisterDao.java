package com.niit.mobilje.dao;

import com.niit.mobilje.trans.LoginDetails;
import com.niit.mobilje.trans.Register;

public interface RegisterDao {
	
	public boolean saveRegister(Register user);
	public boolean isValidUser(LoginDetails log);
	public String isRole();
}
