package com.anu.bank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue
	private int customer_id;   
	public Customer(String first_name, String last_name, long phone_number, String email, String pAN) {
		super();
	
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone_number = phone_number;
		this.email = email;
		this.PAN = pAN;
	}

	private String first_name;
	private String last_name;
	private long phone_number;
	private String email;
	private String PAN;
	
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPAN() {
		return PAN;
	}
	public void setPAN(String pAN) {
		PAN = pAN;
	}
	
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", phone_number=" + phone_number + ", email=" + email + ", PAN=" + PAN + "]";
	}
}

