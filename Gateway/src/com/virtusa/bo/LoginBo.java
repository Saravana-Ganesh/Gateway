package com.virtusa.bo;

public class LoginBo {
	private String email;
	private long password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password.hashCode();
	}

}