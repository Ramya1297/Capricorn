package com.anu.bank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	//@GeneratedValue
	private long account_number;  
	private String account_type;
	private int customer_id ;   
	private float balance;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getAccount_number() {
		return account_number;
	}
	public void setAccount_number(long account_number) {
		this.account_number = account_number;
	}
	
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	public Account(String account_type, int customer_id, float balance) {
		super();
		this.account_type = account_type;
		this.customer_id = customer_id;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [account_number=" + account_number + ", account_type=" + account_type + ", customer_id="
				+ customer_id + ", balance=" + balance + "]";
	}
}
