package com.niit.mobilje.appconfig;


import org.hibernate.exception.GenericJDBCException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(GenericJDBCException.class)
	public String serverDown(){
		return "Error";
	}
}
