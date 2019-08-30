package com.anu.bank.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.anu.bank.model.Account;
import com.anu.bank.model.Customer;
import com.anu.bank.model.Flag;
import com.anu.bank.model.Login;
import com.anu.bank.model.Transaction;
import com.anu.bank.model.SmtMailSender;
import com.anu.bank.repo.AccountRepo;
import com.anu.bank.repo.LoginRepo;
import com.anu.bank.repo.CustomerRepo;
import com.anu.bank.repo.FlagRepo;
import com.anu.bank.repo.TransactionRepo;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.HashMap; 
import java.util.Map;

@RestController
@RequestMapping(value="/web")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BankController {
	
		@Autowired
		AccountRepo adao;
		@Autowired
		LoginRepo ldao;
		@Autowired
		TransactionRepo tdao;
		@Autowired
		CustomerRepo cdao;
		@Autowired
		FlagRepo fdao;
		@Autowired
		   private SmtMailSender smtMailSender ;
			
		@RequestMapping("/send-mail")
		   public void sendMail(  ) throws MessagingException
		   {
			smtMailSender.send("anushakalluri2@gmail.com","test credit and debit","it has to work well!");
			
		   }
		
		public void sendMail( String from_mailid,String to_mailid,float amount ) throws MessagingException
		   {
			   String sub="Transaction Succsessful";
			 
			   smtMailSender.send(from_mailid,sub,"Your Account has been debited by "+amount);
			   smtMailSender.send(to_mailid,sub,"Your Account has been credited by "+amount);
				   
		   }
			// to get last 10 transactions	   
		   @GetMapping("/lastten")
		 public  List<Transaction> last_Ten(@PathVariable long account_number)
		 
				{
			 		System.out.println(account_number);
					return tdao.getLastTen(account_number);
				}
		   // credited last 10 transactions
		   @GetMapping("/creditlastten/{from_acc_num}")
			 public  List<Transaction> crlast_Ten(@PathVariable long from_acc_num)
			 
					{
				 		System.out.println(from_acc_num);
						return tdao.creditLastTen(from_acc_num);
					}
		   //debited last 10 transactions
		   
		   @GetMapping("/debitlastten/{from_acc_num}")
			 public  List<Transaction> drlast_Ten(@PathVariable long from_acc_num)
			 
					{
				 		System.out.println(from_acc_num);
						return tdao.debitLastTen(from_acc_num);
					}
		   /*//getting transactions by date
		   @GetMapping("/debitbydate/{from_acc_num}/{date}")
		   public List<Transaction> drgetByDate( @PathVariable long from_acc_num,String date)
		   {
			   Date d=new Date(date);
			   return tdao.debitByDate(from_acc_num, d);
		   }
		   @GetMapping("/creditbydate/{from_acc_num}/{date}")
		   public List<Transaction> crgetByDate( @PathVariable long from_acc_num,String date)
		   {
			   Date d=new Date(date);
			   return tdao.debitByDate(from_acc_num, d);
		   }
		   */
		 
		   
		  /* @GetMapping("/bymonth/{account_number}") 
			public List<Transaction> getByMonth( @PathVariable long account_number)
			{
				return tdao.getallByMonth(account_number);
			}*/
		   @GetMapping("/getBalance/{account_number}")
		   public Account getBalance(@PathVariable long account_number) {

	    		Account acr=null;
			   if(adao.existsById(account_number))
			   {
		    		Optional<Account> acno=adao.findById(account_number);
		    		if (acno.isPresent()){
			    		  acr = acno.get();
			    		 		}
			    		else {
			    			
					      
			    		}
			   }
			   return acr;
		   }
		
	
		
		    @PostMapping("/login")
			public  HashMap<String, String> login(@RequestBody ObjectNode o)
			
			{
		    	 HashMap<String, String> map = new HashMap<>(); 
		    	int customer_id=o.get("customer_id").asInt();
		    	String password=o.get("password").asText();
		    	
		    	if(ldao.existsById(customer_id))
		    	{
		    		Login loginr=null;
		    		Optional<Login> logino=ldao.findById(customer_id);
		    		if (logino.isPresent()){
			    		  loginr = logino.get();
			    		 		}
			    		else {
			    			/*String jsonStr = "{\"status\": \"invalid\"}";
			   		     
					        JSONObject json = new JSONObject(jsonStr);
					        return json;*/
			    			map.put("status", "invalid");
			    			return map;
					      
			    		}
		    	//Login loginr=ldao.findById(customer_id);
		    	
		    	if(password.equals(loginr.getPassword()))
		    	{
		    		
		    		/*String jsonStr = "{\"status\": \"success\"}";
		   		     
			        JSONObject json = new JSONObject(jsonStr);
			        System.out.println(json);
			        
			        return json;*/
		    		map.put("status", "success");
	    			return map;
		    		
				}
		    	   else 
		    		{
		    		  /* String jsonStr = "{\"status\": \"invalid\"}";
			   		     
				        JSONObject json = new JSONObject(jsonStr);
				        return json;*/
		    		   map.put("status", "invalid");
		    			return map;
		    		}
			}
		    	else
		    	{
		    		/*String jsonStr = "{\"status\": \"invalid\"}";
		   		     
			        JSONObject json = new JSONObject(jsonStr);
			        return json;*/
		    		map.put("status", "invalid");
	    			return map;
		    	}
			}
		    //create new acc
		    @PostMapping("/createNew")
			public void create(@RequestBody ObjectNode o) {
				String type =o.get("account_type").asText();
				int cust_id=o.get("customer_id").asInt();
				Account acc=new Account(type,cust_id,0);
				adao.save(acc);
				//send mail with acc num
				
			}

		    
		    @PostMapping("/register")
		    public void register(@RequestBody ObjectNode o) throws MessagingException
		    {
		    	String firstName=o.get("first_name").asText();
		    	String lastName=o.get("last_name").asText();
		    	String email=o.get("email").asText();
		        long  phone_number=o.get("phone_number").asLong();
		        String pan=o.get("PAN").asText();
		        String password=o.get("password").asText();
		       // String confirm_Password=o.get("confirm_Password").asText();
		        
		        Customer customer=new Customer(firstName,lastName,phone_number,email,pan);
		        System.out.println(password);
		        Customer c=cdao.save(customer);
		        System.out.println(c);
		       Login login=new Login(c.getCustomer_id(),password);
		       ldao.save(login);
		       //send mail with custid and password
		       String msg="welcome to Bank Of Hyatt"+"\n"+"your customer id is :"+c.getCustomer_id()+"\n"+"your password:"+password;
		       ;
		       smtMailSender.send(email,"welcome",msg);
		       
		    	
		    	
		    }
		@PostMapping("/transfer")
			public HashMap<String, String> transfer(@RequestBody ObjectNode o) throws MessagingException {
			HashMap<String, String> map = new HashMap<>(); 
			long from_acc_num=o.get("from_acc_num").asLong();
			
;
			long to_acc_num=o.get("to_acc_num").asLong();
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
		       		adao.save(to);
		       		Date date=new Date();
		     	       Transaction transaction = new Transaction(from_acc_num,to_acc_num, amount,date, from.getAccount_type(),to.getAccount_type());
	       	       		tdao.save(transaction);
	       	       //	sendMail("anushakalluri2@gmail.com","debit");
	       	    // sendMail("csebvvit123@gmail.com","credit");
	       	       	 Customer  custfrom;
			    		Optional<Customer> custfromopt = cdao.findById(from.getCustomer_id());
			    		   custfrom = custfromopt.get();
			    		   //custfrom.getMail();
			    		
			    		Customer  cust_to;
			    		Optional<Customer> cust_toopt = cdao.findById(to.getCustomer_id());
			    			   cust_to = cust_toopt.get();
			    		   //custfrom.getMail();
			    			   System.out.println(custfrom.getEmail());
			    			   System.out.println(cust_to.getEmail());
						    	
	       	       	sendMail(custfrom.getEmail() ,cust_to.getEmail(),amount);
	       	       		
		     	    		  
		       	       		
		       	         if(amount>10000) {
		       		    	//report alert
		       	        	 Flag  f=new Flag(transaction.getTid(),amount);
		       	        	//smtMailSender.send("anushakalluri2@gmail.com","Transaction is overlimit","performed transaction over 10,000");
		       		    	fdao.save(f);
		       		    	smtMailSender.send("anushakalluri2@gmail.com","Transaction is overlimit","performed transaction over 10,000");
		       	        	 
		       		    	
		       		    }
		    		
		    			map.put("status","success");
		    			return map;
		    		}
		    		else {
		    			map.put("status","nobal");
		    			return map;
		    		}
		    	}
		    	
		    	else {
		    		map.put("status","failed");
	    			return map;
		    	}
		    }
		@GetMapping("/transactions")
		
			public List<Transaction> displaytransactions()
			{
				return tdao.findAll();
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
		
		
		@GetMapping("/displayid{customer_id}")
		
		public Optional<Customer> displayCarById(@PathVariable int customer_id)
		{
			System.out.println("customer id:"+customer_id);
			return cdao.findById(customer_id);
		}
		@GetMapping("/getAllAccounts/{customer_id}")
		public List<Account> getacc(@PathVariable int customer_id){
			return adao.getAllAccounts(customer_id);
			 
		}
		@GetMapping("/customers/{customer_id}")
		public Customer retrieveCustomer(@PathVariable int customer_id) {
			Optional<Customer> customer = cdao.findById(customer_id);

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
		public Customer updatecustomer(@RequestBody Customer customer){
		return cdao.save(customer);
		}
		
		@DeleteMapping("/customer/{customer_id}")
		public List<Customer> deletecustomer(@PathVariable Integer customer_id) {
			cdao.deleteById(customer_id);
			return cdao.findAll();
		}
		
		
	}


