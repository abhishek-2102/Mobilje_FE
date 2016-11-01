package com.niit.mobilje.controller;

public class UserDetails {
public String username;
public String email;
public String confirm_email;
public String dob;
public String number;
public String password;
public String confirm_password;
public String address;

public String getConfirm_password() {
	return confirm_password;
}
public void setConfirm_password(String confirm_password) {
	this.confirm_password = confirm_password;
}

public String getConfirm_email() {
	return confirm_email;
}
public void setConfirm_email(String confirm_email) {
	this.confirm_email = confirm_email;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}

public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

}
