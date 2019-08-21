package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Login;

public interface LoginDao extends JpaRepository<Login, Integer>  {

}
