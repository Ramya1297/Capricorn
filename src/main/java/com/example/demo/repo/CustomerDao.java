package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

}
