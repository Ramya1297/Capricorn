package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Transaction;

public interface TransactionDao extends JpaRepository<Transaction, Integer> {

}
