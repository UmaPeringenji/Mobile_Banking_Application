package com.ajp.service;


import com.ajp.entity.Transactions;

public interface TransactionsService {
	
	void transactionsDetails(String accountNumber, Transactions transactions);
	void withdrawAmount(String accountNumber,Double amount) throws BalanceException;
	void depositAmount(String accountNumber,Double amount) throws BalanceException;

	void getTransactionsDetails(String id);
	

}
