package com.labs.users.services.viewmodels;

public class Login extends BaseModel {

	private String Username;
	
	private String Password;

	public String getUsername() {
		return Username;
	}
	
	public void setUsername(String username) {
		Username = username;
	}
	
	public String getPassword() {
		return Password;
	}
	
	public void setPassword(String password) {
		Password = password;
	}

}
