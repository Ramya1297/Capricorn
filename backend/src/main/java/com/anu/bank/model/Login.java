package com.anu.bank.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login {
	
	@Id
	private int customer_id;
	private String password;
	
	
	public int getUserid() {
		return customer_id;
	}
	public void setUserid(int customer_id) {
		this.customer_id = customer_id;
	}

	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Authenticate [userid=" + customer_id + ", password=" + password + "]";
	}
	public Login(int customer_id, String password) {
		super();
		this.customer_id = customer_id;
		this.password = password;
	}
	
	
}
