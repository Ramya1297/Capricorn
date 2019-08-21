package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
@Id
int cust_id;
String area;
String city;
String state;
public int getCust_id() {
	return cust_id;
}
public void setCust_id(int cust_id) {
	this.cust_id = cust_id;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
@Override
public String toString() {
	return "Address [cust_id=" + cust_id + ", area=" + area + ", city=" + city + ", state=" + state + "]";
}


}
