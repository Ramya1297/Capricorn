package com.anu.bank.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Transaction {
	
	
	
	@Id
	@GeneratedValue
	int tid;
	long from_acc_num;
	long to_acc_num;
	float amount;
	Date date;
	String from_acc_type;
	String to_acc_type;
	
public Transaction(long from_acc_num, long to_acc_num, float amount, Date date, String from_acc_type,
			String to_acc_type) {
		super();
		this.from_acc_num = from_acc_num;
		this.to_acc_num = to_acc_num;
		this.amount = amount;
		this.date = date;
		this.from_acc_type = from_acc_type;
		this.to_acc_type = to_acc_type;
	}

public String getFrom_acc_type() {
	return from_acc_type;
}

public void setFrom_acc_type(String from_acc_type) {
	this.from_acc_type = from_acc_type;
}

public String getTo_acc_type() {
	return to_acc_type;
}

public void setTo_acc_type(String to_acc_type) {
	this.to_acc_type = to_acc_type;
}

public int getTid() {
	return tid;
}

public void setTid(int tid) {
	this.tid = tid;
}

public long getFrom_acc_num() {
	return from_acc_num;
}

public void setFrom_acc_num(long from_acc_num) {
	this.from_acc_num = from_acc_num;
}

public long getTo_acc_num() {
	return to_acc_num;
}

public void setTo_acc_num(long to_acc_num) {
	this.to_acc_num = to_acc_num;
}

public float getAmount() {
	return amount;
}

public void setAmount(float amount) {
	this.amount = amount;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public Transaction() {
	super();
	// TODO Auto-generated constructor stub
}

}
