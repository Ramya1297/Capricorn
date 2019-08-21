package com.example.demo.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Account;
import com.example.demo.Customer;
import com.example.demo.Flag;
import com.example.demo.Login;
import com.example.demo.Transaction;
import com.example.demo.repo.AccountDao;
import com.example.demo.repo.AddressDao;
import com.example.demo.repo.CustomerDao;
import com.example.demo.repo.FlagDao;
import com.example.demo.repo.LoginDao;
import com.example.demo.repo.TransactionDao;
import com.fasterxml.jackson.databind.node.ObjectNode;



@RestController
@RequestMapping(value="/web")
public class MyController {
	@Autowired
	AccountDao adao;
	@Autowired
	AddressDao addao;
	@Autowired 
	CustomerDao cdao;
	@Autowired
	LoginDao ldao;
	@Autowired
	TransactionDao tdao;
	@Autowired
	FlagDao fdao;
	
	/*@PostMapping("/login")
	public String login(@RequestBody Login login) {
		int id = login.getCust_id();
		String pass=login.getPassword();
		if(ldao.existsById(id)) {
			Login loginCred;
			Optional<Login> loginopt=ldao.findById(id);
			if(loginopt.isPresent()) {
				loginCred=loginopt.get();
				if(loginCred.getPassword().equals(pass)) {
					return "success..welcome";
				}
				else {
					return "incorrect password";
				}
				
			}
			else {
				loginCred=new Login();
			}
		}
		else {
			return "no such customer";
			
		}
		return null;	
	}
	*/
	@PostMapping("/transfer")
		public String transfer(@RequestBody ObjectNode o) {
		int from_acc_num=o.get("from_acc_num").asInt();
		int to_acc_num=o.get("to_acc_num").asInt();
	    float amount=(float)o.get("amount").asDouble();
		
	   
	    	if(adao.existsById(from_acc_num) && adao.existsById(to_acc_num)) {
	    	    Account from;
	    		Optional<Account> fromopt = adao.findById(from_acc_num);
	    		if (fromopt.isPresent()){
	    		   from = fromopt.get();
	    		 		}
	    		else {
	    			 from=new Account();
	    		}
	    			if(from.getBalance()>(amount)+5000) {
	    				
	    		from.setBalance(from.getBalance()-amount);
	       		adao.save(from);
         		Account to;
	    		Optional<Account> toopt = adao.findById(to_acc_num);
	    		if (toopt.isPresent()){
	    		   to= toopt.get();
	    		   
	    		}
	    		else {
	    			 to=new Account();
	    		}
	    		
	       		to.setBalance(to.getBalance()+amount);
	       		adao.save(from);
	       	Date date=new Date();
	     	       Transaction transaction = new Transaction(from_acc_num,to_acc_num, amount,date, from.getAcc_type(),to.getAcc_type());
	       	       		tdao.save(transaction);
	       	       		
	       	         if(amount>10000) {
	       		    	//report /alert
	       	        	 Flag  f=new Flag(transaction.getTid(),amount);
	       		    	fdao.save(f);
	       	        	 
	       		    	
	       		    }
	    		return "succesful transaction";
	    		}
	    		else {
	    			return "no sufficient balance";
	    		}
	    	}
	    	
	    	else {
	    		return "incorrect account number";
	    	}
	    }
    
/*	@PostMapping("/MyProfile")
	
	public Customer displayById(@RequestBody int cust_id)
	{
		Optional<Customer> custOpt=cdao.findById(cust_id);
		Customer customer;
		if(custOpt.isPresent()) {
			customer=custOpt.get();
		}
		else {
			customer=null;
			}
		return customer;
	
	}
	
	*/
	
	
	@RequestMapping(value="/displayid{cust_id}")
	@ResponseBody
	public Optional<Customer> displayCarById(@PathVariable int cust_id)
	{
		System.out.println("customer id:"+cust_id);
		return cdao.findById(cust_id);
	}
	@GetMapping("/customers/{cust_id}")
	public Customer retrieveCustomer(@PathVariable int cust_id) {
		Optional<Customer> customer = cdao.findById(cust_id);

		if (!customer.isPresent())
			System.out.println("no customer found with this id");

		return customer.get();
	}
	@GetMapping("/displayall")
	public List<Customer> findAll()
	{   // System.out.println("findall");
		return cdao.findAll();
	}
	
	@PostMapping("/inserting")
	public Customer save(@RequestBody Customer customer)
	{
		return cdao.save(customer);
	}
	
	
	@PutMapping("/update")
	public Customer updateBook(@RequestBody Customer customer){
	return cdao.save(customer);
	}
	
	@DeleteMapping("/customer/{cust_id}")
	public List<Customer> deleteCar(@PathVariable Integer cust_id) {
		cdao.deleteById(cust_id);
		return cdao.findAll();
	}
}
