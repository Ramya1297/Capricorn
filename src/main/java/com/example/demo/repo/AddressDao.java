package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Address;

public interface AddressDao extends JpaRepository<Address, Integer>{

}
