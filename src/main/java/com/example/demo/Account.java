package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	int acc_num;
	float balance;
	String acc_type;
	public int getAcc_num() {
		return acc_num;
	}
	public void setAcc_num(int acc_num) {
		this.acc_num = acc_num;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getAcc_type() {
		return acc_type;
	}
	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}
	@Override
	public String toString() {
		return "Account [acc_num=" + acc_num + ", balance=" + balance + ", acc_type=" + acc_type + "]";
	}
	
}
