package com.example.demo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Transaction {
	@Id
	@GeneratedValue
	int tid;
	int from_acc_num;
	int to_acc_num;
	float amount;
	Date date;
	String from_acc_type;
	String to_acc_type;
	
public Transaction(int from_acc_num, int to_acc_num, float amount, Date date, String from_acc_type,
			String to_acc_type) {
		super();
		this.from_acc_num = from_acc_num;
		this.to_acc_num = to_acc_num;
		this.amount = amount;
		this.date = date;
		this.from_acc_type = from_acc_type;
		this.to_acc_type = to_acc_type;
	}
public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getFrom_acc_num() {
		return from_acc_num;
	}
	public void setFrom_acc_num(int from_acc_num) {
		this.from_acc_num = from_acc_num;
	}
	public int getTo_acc_num() {
		return to_acc_num;
	}
	public void setTo_acc_num(int to_acc_num) {
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
	public String getFrom_acc_type() {
		return from_acc_type;
	}
	public void setFrom_acc_tyoe(String from_acc_type) {
		this.from_acc_type = from_acc_type;
	}
	public String getTo_acc_type() {
		return to_acc_type;
	}
	public void setTo_acc_type(String to_acc_type) {
		this.to_acc_type = to_acc_type;
	}
	@Override
	public String toString() {
		return "Transaction [tid=" + tid + ", from_acc_num=" + from_acc_num + ", to_acc_num=" + to_acc_num
				+ ", amount=" + amount + ", date=" + date + ", from_acc_type=" + from_acc_type + ", to_acc_type="
				+ to_acc_type + "]";
	}

}
