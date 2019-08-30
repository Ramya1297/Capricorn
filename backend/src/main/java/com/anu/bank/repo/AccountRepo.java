package com.anu.bank.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anu.bank.model.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
	@Query("from Account where customer_id=?1")
	public List<Account> getAllAccounts(int customer_id);
		
	
	

}
