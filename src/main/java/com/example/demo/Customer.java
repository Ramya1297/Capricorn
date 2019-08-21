package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
@Id
private int cust_id;
private String name;
private int phone;
private String email;
private int acc_num;
private int aadhar_num;
public int getCust_id() {
	return cust_id;
}
public void setCust_id(int cust_id) {
	this.cust_id = cust_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPhone() {
	return phone;
}
public void setPhone(int phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getAcc_num() {
	return acc_num;
}
public void setAcc_num(int acc_num) {
	this.acc_num = acc_num;
}
public int getAadhar_num() {
	return aadhar_num;
}
public void setAadhar_num(int aadhar_num) {
	this.aadhar_num = aadhar_num;
}
@Override
public String toString() {
	return "Customer [cust_id=" + cust_id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", acc_num="
			+ acc_num + ", aadhar_num=" + aadhar_num + "]";
}

}
