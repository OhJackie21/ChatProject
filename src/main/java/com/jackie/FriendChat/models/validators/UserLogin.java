package com.jackie.FriendChat.models.validators;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserLogin {

//Object specific attributes -----------------
	@NotEmpty(message="Email is required")
	@Email(message="Email/Password is not valid")
	private String email;
	
	@NotEmpty(message="Password is required")
	@Size(min=8, max=30, message="Password must be between 8 and 30 characters long")
	private String password;

//Empty Contructor-------------------------------
	public UserLogin() {}

//Getters and Setters---------------------------
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
		
}
