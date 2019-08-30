package com.anu.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anu.bank.model.Login;

@Repository
public interface LoginRepo extends JpaRepository<Login, Integer> {


}
