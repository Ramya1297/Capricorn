package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flag {
@Id
int tid;
float amount;
public int getTid() {
	return tid;
}
public void setTid(int tid) {
	this.tid = tid;
}
public float getAmount() {
	return amount;
}
public void setAmount(float amount) {
	this.amount = amount;
}
@Override
public String toString() {
	return "Flag [tid=" + tid + ", amount=" + amount + "]";
}
public Flag(int tid, float amount) {
	super();
	this.tid = tid;
	this.amount = amount;
}
public Flag() {
	super();
	// TODO Auto-generated constructor stub
}

}
