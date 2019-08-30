package com.anu.bank.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anu.bank.model.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
	@Query(" from Transaction where from_acc_num=?1 or to_acc_num=?1  order by date")
public List<Transaction> getLastTen(Long account_number);

	@Query(" from Transaction where to_acc_num=?1 order by date")
	public List<Transaction> creditLastTen(Long from_acc_num);
	
	@Query(" from Transaction where from_acc_num=?1 order by date")
	public List<Transaction> debitLastTen(Long from_acc_num);
	
	/*
	@Query(" from Transaction where to_acc_num=?1 and date between date=2? and curdate() order by date")
	public List<Transaction> creditByDate(Long from_acc_num, Date date);
	
	@Query(" from Transaction where from_acc_num=?1 and date between date=2? and curdate() order by date")	
	public List<Transaction> debitByDate(Long from_acc_num, Date date);
	*/
	
}