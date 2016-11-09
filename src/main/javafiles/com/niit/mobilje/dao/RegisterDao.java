package com.niit.mobilje.dao;

import java.util.List;

import com.niit.mobilje.trans.RegisterDetails;

public interface RegisterDao {
	boolean saveRegister(RegisterDetails user);
	/*boolean updateRegister(RegisterDetails user);
	boolean delRegister(RegisterDetails user);
	List<RegisterDetails> list();
	
*/
}
