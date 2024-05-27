package com.ajp.service;

import java.util.InputMismatchException;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;

import org.hibernate.Transaction;


import com.ajp.entity.Account;
import com.ajp.entity.Bank;
import com.ajp.entity.Customer;
import com.ajp.entity.Feedback;
import com.ajp.entity.Transactions;
import com.ajp.utility.UtilityConfig;

public class ServiceImpl implements Service,TransactionsService{
	
	Session session;
	Transaction transaction;

	public void insertbankDetails(Bank bank) {
		try {
		session=UtilityConfig.getSession();
		transaction=session.beginTransaction();
		session.saveOrUpdate(bank);
		transaction.commit();
		System.out.println("Bank details are inserted successfully");
		}catch (InputMismatchException e) {
			System.out.println("Enter valid data....");
		}
		finally {
	    session.close();
		}
	}

	public void insertcustomerDetails(Customer customer) {
		try {
		session=UtilityConfig.getSession();
		transaction=session.beginTransaction();
		session.saveOrUpdate(customer);
		transaction.commit();
		System.out.println("Customer details are inserted successfully");
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
		    session.close();
		}
		
	}

	public void insertaccountDetails(Account account) {
		try {
		session=UtilityConfig.getSession();
		transaction=session.beginTransaction();
		session.saveOrUpdate(account);
		transaction.commit();
		System.out.println("Account details are inserted successfully");
		}finally {
		    session.close();
		}
		
	}

        public void addAccountToBank(String bankId,Account account) {
		try {
		session=UtilityConfig.getSession();
		transaction=session.beginTransaction();
		
		Bank bank=session.get(Bank.class, bankId);
		
		bank.getAccount().add(account); // add account to the bank
		account.setBank(bank);         //set bank for the account
	    
		session.saveOrUpdate(account);
		transaction.commit();
		System.out.println("Bank details are added to account");
		}finally {
		    session.close();
		}
		
	}

	public void addCustomerToAccount(String customerId,String accountId) {
		try {
		session=UtilityConfig.getSession();
		transaction=session.beginTransaction();
		
		Customer customer=session.get(Customer.class, customerId);
		Account account=session.get(Account.class, accountId);
		
		customer.getAccount().add(account);
		account.setCustomer(customer);
		
		session.saveOrUpdate(account);
		transaction.commit();
		System.out.println("Customer details are added to account");
		}finally {
		    session.close();
		}
		
	}

	public void getFeedbackByCustomer(String customerId, Feedback feedback) {
		try {
		session=UtilityConfig.getSession();
		transaction=session.beginTransaction();
		Customer customer=session.get(Customer.class, customerId);
		feedback.setCustomer(customer);
		session.saveOrUpdate(feedback);
		transaction.commit();
		System.out.println("Feedback given by customer");
		}finally {
		    session.close();
		}
		
	}

	public void saveCustomerFeedback(String bankId, Feedback feedback) {
		try {
		session=UtilityConfig.getSession();
		transaction=session.beginTransaction();
		Bank bank=session.get(Bank.class, bankId);
		feedback.setBank(bank);
		session.saveOrUpdate(feedback);
		transaction.commit();
		System.out.println("Bank received feedback from customer");
		}finally {
		    session.close();
		}
		
	}

	public void transactionsDetails(String accountNumber, Transactions transactions) {
		try {
		session=UtilityConfig.getSession();
		transaction=session.beginTransaction();
		Account account=session.get(Account.class, accountNumber);
		account.getTransactions().add(transactions);
		transactions.setAccount(account);
		session.saveOrUpdate(transactions);
		transaction.commit();
		System.out.println("added transaction details");
		}finally {
		    session.close();
		}		
	}

	public void withdrawAmount(String accountNumber, Double amount) {
		try {
		session=UtilityConfig.getSession();
		transaction=session.beginTransaction();
		Account account=session.get(Account.class, accountNumber);
		double balance=account.getBalance();
		System.out.println("Balance : "+balance);
		
		if(amount<balance) {
			double newBalance = account.getBalance()-amount;
	        account.setBalance(newBalance);
	        System.out.println("After withdraw amount balance is : "+newBalance);
	        session.saveOrUpdate(account);
	        transaction.commit();
	        System.out.println("Withdrawa successfully...");
		}else {
			throw new BalanceException("Amount is not sufficient....");
		}
		} catch (BalanceException e) {
			e.printStackTrace();
		}finally {
		    session.close();
		}
	}

	public void depositAmount(String accountNumber, Double amount) {
		try {
		session=UtilityConfig.getSession();
		transaction=session.beginTransaction();
		Account account=session.get(Account.class, accountNumber);
		double balance=account.getBalance();
		System.out.println("Balance : "+balance);
		
		if(amount>10) {
			double newBalance = account.getBalance()+amount;
	        account.setBalance(newBalance);
	        System.out.println("After deposit amount balance is : "+newBalance);
	        session.saveOrUpdate(account);
	        transaction.commit();
	        System.out.println("Deposit successful...");
		}else {
			throw new BalanceException("Below 10 rupees is not deposit to the account.....");
		}
		} catch (BalanceException e) {
			e.printStackTrace();
		}finally {
		    session.close();
		}		
	}

	public void getBank(String id){
		try {
		session=UtilityConfig.getSession();
		Bank bid=session.load(Bank.class, id);
		if(bid==null) {
			throw new InvalidBankDetailsException("Enter valid data....");
		}else {
		System.out.println("Bank details : "+bid);
		}
		}
		catch (InvalidBankDetailsException e) {
			e.printStackTrace();
		}		
	}

	public void getCustomer(String id) {
		try {
		session=UtilityConfig.getSession();
		Customer cid=session.load(Customer.class, id);
		if(cid==null) {
			throw new InvalidBankDetailsException("Enter valid data....");
		}else {
		System.out.println("Customer details : "+cid);
		}
		}
		catch (ObjectNotFoundException e) {
	        System.out.println("Customer not found with ID: " + id);
	    }
		catch (InvalidBankDetailsException e) {
			System.out.println("Enter valid data...");
		}finally {
		session.close();
		}		
	}

	public void getAccountById(String id) {
		try {
		session = UtilityConfig.getSession();
        Account aid = session.load(Account.class, id);
        if(aid==null) {
			throw new InvalidBankDetailsException("Enter valid data....");
		}else {
			System.out.println("Account Details : ");
	        System.out.println("ID: " + aid.getAccountNumber());
	        System.out.println("AccountType : "+aid.getAccountType());
	        System.out.println("Balance: " + aid.getBalance());
		}
       }
		catch (ObjectNotFoundException e) {
	        System.out.println("Account not found with ID: " + id);
	    }  
		catch (InvalidBankDetailsException e) {
			System.out.println("Enter valid data....");
	} finally {
    	session.close();
       }		
	}

	public void getTransactionsDetails(String id) {
		try {
			session = UtilityConfig.getSession();
	        Transactions tid = session.load(Transactions.class, id);
	        if(tid==null) {
				throw new InvalidBankDetailsException("Enter valid data....");
			}else {
	        System.out.println("Transaction Details : "+tid);
			}
	       } 
		catch (ObjectNotFoundException e) {
		        System.out.println("Transaction not found with ID: " + id);
		    }
		catch (InvalidBankDetailsException e) {
	    	   System.out.println("Enter valid data...");
		} finally {
	    	session.close();
	     }
		
	}
	
}	
	
	

	
