package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Flag;

public interface FlagDao extends JpaRepository<Flag, Integer>{

}
