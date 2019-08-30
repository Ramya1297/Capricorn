package com.anu.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anu.bank.model.Flag;


@Repository
public interface FlagRepo extends JpaRepository<Flag, Integer>{

}
