package com.anu.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anu.bank.model.Customer;

@Repository
public interface CustomerRepo  extends JpaRepository<Customer, Integer>{

	
}

