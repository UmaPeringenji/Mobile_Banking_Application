package com.ajp.app;

import java.time.LocalDate;
import java.util.Scanner;

import com.ajp.entity.Account;
import com.ajp.entity.Bank;
import com.ajp.entity.Customer;
import com.ajp.entity.Feedback;
import com.ajp.entity.Transactions;
import com.ajp.service.BalanceException;
import com.ajp.service.Service;
import com.ajp.service.ServiceImpl;
import com.ajp.service.TransactionsService;

public class BankApplication {

	public static void main(String[] args) throws BalanceException  {
		
		System.out.println("Welcome to Mobile Banking Application");
		Service service = new ServiceImpl();
		TransactionsService tservice=new ServiceImpl();
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("You are 1.New Customer\n 2.Bank Customer \n Enter Option");
		int user = sc.nextInt();
		if (user == 1) {	
	        System.out.println("1. Insert bank details");
	        System.out.println("2. Insert account details");
	        System.out.println("3. Insert customer details");
	        System.out.println("4. Transaction Service(Deposit/Withdraw)");
	        System.out.println("5. Get bank details");
	        System.out.println("6. Get customer details");
	        System.out.println("7. Get Account details");
	        System.out.println("8. Get Transactions details");
	        System.out.println("9. Feedback");
	        System.out.println("Enter option : ");
	        
	        int choice = sc.nextInt();
	
	        while(choice>0) {
	   
	        switch (choice) {
	            case 1:
	                System.out.println("Enter Bank Id: ");
	                String bankId = sc.next();
	                sc.nextLine();
	                System.out.println("Enter Bank Name: ");
	                String bankName = sc.next();
	                sc.nextLine();
	                System.out.println("Enter Bank Contact number: ");
	                int contactNumber = sc.nextInt();
	                sc.nextLine(); // consume the newline character
	                System.out.println("Enter Bank city: ");
	                String city = sc.nextLine();
	
	                Bank bank = new Bank();
	                bank.setBankId(bankId);
	                bank.setBankName(bankName);
	                bank.setContactNumber(contactNumber);
	                bank.setCity(city);
	
	                service.insertbankDetails(bank);
	                break;
	
	            case 2:
	            	System.out.println("Enter Account Number : ");
	            	String accountNumber=sc.next();
	            	System.out.println("Enter Account Type : ");
	            	String actype=sc.next();
	            	System.out.println("Enter Balance : ");
	            	double balance=sc.nextDouble();            	
	            	Account account=new Account();
	            	account.setAccountNumber(accountNumber);
	            	account.setAccountType(actype);
	            	account.setBalance(balance);
	            	service.insertaccountDetails(account);
	            	 
	            	System.out.println("Enter bank Id: ");
	            	service.addAccountToBank(sc.next(), account);
	            	System.out.println("enter customer id: ");
	            	System.out.println("Enter Account Id : ");
	            	service.addCustomerToAccount(sc.next(), sc.next());
	            	
	            	
	            	break;
	            
	            case 3:
	            	System.out.println("Enter Customer Id : ");
	            	String cid=sc.next();
	            	System.out.println("Enter Customer Name : ");
	            	String cname=sc.next();
	            	sc.nextLine();
	            	System.out.println("Enter Email Id : ");
	            	String email=sc.next();
	            	sc.nextLine();
	            	System.out.println("Enter date od birth : ");
	            	String dob=sc.next();
	            	sc.nextLine();
	            	LocalDate dobate=LocalDate.parse(dob);
	            	System.out.println("Enter  Contact number: ");
	                int ph = sc.nextInt();
	                sc.nextLine(); // consume the newline character
	                System.out.println("Enter city: ");
	                String c = sc.nextLine();
	            	
	                Customer customer=new Customer();
	                customer.setCustomerId(cid);
	                customer.setCustomername(cname);
	                customer.setEmail(email);
	                customer.setDob(dobate);
	                customer.setPhoneNumber(ph);
	                customer.setCity(c);
	                service.insertcustomerDetails(customer);
	                break;
	                
	            case 4:
	            	System.out.println("Enter account number : ");
	            	String acc = sc.next();
	            	sc.nextLine();
	            	System.out.println("Enter Transaction Id : ");
	            	String tid=sc.next();
	            	System.out.println("Enter Transaction Amount : ");
	            	double tamount=sc.nextDouble();
	            	System.out.println("Enter Transaction date : ");
	            	String tdate=sc.next();
	            	LocalDate date=LocalDate.parse(tdate);
	            	System.out.println("Enter Transaction Type : deposit/withdraw ");
	            	String type=sc.next();
	            	
	            	
	            	if (type.equalsIgnoreCase("deposit")) {
	            	    tservice.depositAmount(acc, tamount);
	            	} else {
	            	    tservice.withdrawAmount(acc, tamount);
	            	}
	
	            	
	            	Transactions trans=new Transactions();
	            	
	            	trans.setTransactionId(tid);
	            	trans.setTransactionAmount(tamount);
	            	trans.setTransactionDate(date);
	            	trans.setTransactionType(type);
	            	tservice.transactionsDetails(acc, trans);          	
	            	break;
	     
	               case 5:
	            		System.out.println("Enter Bank Id");
	    			String id=sc.next();
	    			service.getBank(id);
	    			break;
	    			
	    		case 6:
	    			System.out.println("Enter Customer Id");
	    			String custid=sc.next();
	    			service.getCustomer(custid);
	    			break;
	    			
	    		case 7:
	    			System.out.println("Enter Account Id");
	    			String aid=sc.next();
	    			service.getAccountById(aid);
	    			break;
	
	    		case 8:
	    			System.out.println("Enter Transactions Id");
	    			String transid=sc.next();
	    			tservice.getTransactionsDetails(transid);
	    			break;
	    			
	    		case 9:
	    			System.out.println("Enter Feedback id");
	    			String fid=sc.next();
	    			System.out.println("Enter message");
	    			String message=sc.next();
	    			sc.nextLine();
	    			Feedback feedback=new Feedback();
	    			feedback.setFeedbackId(fid);
	    			feedback.setMessage(message);
				System.out.println("Enter customer Id");
				service.getFeedbackByCustomer(sc.next(), feedback);
				System.out.println("Enter Bank Id");
				service.saveCustomerFeedback(sc.next(), feedback);
	    			break;
	    			
	             default:
	                System.out.println("Invalid choice");
	                break;
	        }
	        
	        System.out.println("1. Insert bank details");
	        System.out.println("2. Insert account details");
	        System.out.println("3. Insert customer details");
	        System.out.println("4. Transaction Service(Deposit/Withdraw)");
	        System.out.println("5. Get bank details");
	        System.out.println("6. Get customer details");
	        System.out.println("7. Get Account details");
	        System.out.println("8. Get Transaction Details");
	        System.out.println("9. Feedback");
	        System.out.println("Enter 0 to exit");
	        
	        choice = sc.nextInt();
			
		}
	        System.out.println("Thank you.... ");	
	}  else if(user==2) {
		
	    System.out.println("1. Transaction Service(Deposit/Withdraw)");
	    System.out.println("2. Get bank details");
	    System.out.println("3. Get customer details");
	    System.out.println("4. Get Account details");
	    System.out.println("5. Get Transactions details");
	    System.out.println("6. Feedback");
	    int choice = sc.nextInt();
	
	    while(choice>0) {
	
	    switch (choice) {
	
		    case 1:
		    	System.out.println("Enter account number : ");
		    	String acc = sc.next();
		    	sc.nextLine();
		    	System.out.println("Enter Transaction Id : ");
		    	String tid=sc.next();
		    	System.out.println("Enter Transaction Amount : ");
		    	double tamount=sc.nextDouble();
		    	System.out.println("Enter Transaction date : ");
		    	String tdate=sc.next();
		    	LocalDate date=LocalDate.parse(tdate);
		    	System.out.println("Enter Transaction Type : deposit/withdraw ");
		    	String type=sc.next();
		    	
		    	
		    	if (type.equalsIgnoreCase("deposit")) {
		    	    tservice.depositAmount(acc, tamount);
		    	} else {
		    	    tservice.withdrawAmount(acc, tamount);
		    	}
		  	
		    	Transactions trans=new Transactions();
		    	
		    	trans.setTransactionId(tid);
		    	trans.setTransactionAmount(tamount);
		    	trans.setTransactionDate(date);
		    	trans.setTransactionType(type);
		    	tservice.transactionsDetails(acc, trans);          	
		    	break;
		
		       case 2:
		    	        System.out.println("Enter Bank Id");
				String id=sc.next();
				service.getBank(id);
				break;
				
			case 3:
				System.out.println("Enter Customer Id");
				String custid=sc.next();
				service.getCustomer(custid);
				break;
				
			case 4:
				System.out.println("Enter Account Id");
				String aid=sc.next();
			        service.getAccountById(aid);
				System.out.println("enter valid data ......");
				break;
		
			case 5:
				System.out.println("Enter Transactions Id");
				String transid=sc.next();
				tservice.getTransactionsDetails(transid);
				break;
				
			case 6:
				System.out.println("Enter Feedback id");
				String fid=sc.next();
				System.out.println("Enter message");
				String message=sc.next();
				sc.nextLine();
				Feedback feedback=new Feedback();
				feedback.setFeedbackId(fid);
				feedback.setMessage(message);
				
				System.out.println("Enter customer Id");
				service.getFeedbackByCustomer(sc.next(), feedback);
				
				System.out.println("Enter Bank Id");
				service.saveCustomerFeedback(sc.next(), feedback);
				break;
				
	        default:
	            System.out.println("Invalid choice");
	            break;
	    }
	    
	    System.out.println("1. Transaction Service(Deposit/Withdraw)");
	    System.out.println("2. Get bank details");
	    System.out.println("3. Get customer details");
	    System.out.println("4. Get Account details");
	    System.out.println("5. Get Transactions details");
	    System.out.println("6. Feedback");
	    System.out.println("Enter 0 to exit");
	    
	    choice = sc.nextInt();
	    }
		System.out.println("Thank you.... ");	
				
	 }
	sc.close();
		
}
}
