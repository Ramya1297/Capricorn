package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login {
	@Id
int cust_id;
String password;
public int getCust_id() {
	return cust_id;
}
public void setCust_id(int cust_id) {
	this.cust_id = cust_id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Login [cust_id=" + cust_id + ", password=" + password + "]";
}

}
