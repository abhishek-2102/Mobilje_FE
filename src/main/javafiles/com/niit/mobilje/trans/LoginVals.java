package com.niit.mobilje.trans;

import org.springframework.stereotype.Component;

@Component
public class LoginVals {
	
	private String signIn;

	private String signUp;

	
	public String getSignIn() {
		return signIn;
	}

	public void setSignIn(String signIn) {
		this.signIn = signIn;
	}

	public String getSignUp() {
		return signUp;
	}

	public void setSignUp(String signUp) {
		this.signUp = signUp;
	}
	

}
