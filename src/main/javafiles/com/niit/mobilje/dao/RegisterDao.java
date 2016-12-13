package com.niit.mobilje.dao;

import com.niit.mobilje.trans.LoginDetails;
import com.niit.mobilje.trans.Register;

public interface RegisterDao {
	//for user register
	public boolean saveRegister(Register user);
	//to check if the login user matches with the database
	public Register isValidUser(LoginDetails log);
	//
	public Register regDetails();
}
