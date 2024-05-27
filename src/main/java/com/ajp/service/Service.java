package com.ajp.service;

import com.ajp.entity.Account;
import com.ajp.entity.Bank;
import com.ajp.entity.Customer;
import com.ajp.entity.Feedback;

public interface Service {
	
	void insertbankDetails(Bank bank);
	void insertcustomerDetails(Customer customer);
	void insertaccountDetails(Account account);
	
	void addAccountToBank(String bankId,Account account);
	void addCustomerToAccount(String customerId,String accountId);
	
	void getFeedbackByCustomer(String customerId,Feedback feedback);
	void saveCustomerFeedback(String bankId,Feedback feedback);
	
	void getBank(String id) ;
	void getCustomer(String id);
	void getAccountById(String id);

}
