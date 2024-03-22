package com.ajp.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Account {
	
	@Id
	private String accountNumber;
	private String accountType;
	private double balance;
	
	@ManyToOne
	@JoinColumn(name="bankId")
	private Bank bank;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	
	@OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
	Set<Transactions> transactions=new HashSet<Transactions>();

	public Account() {
		super();
	}

	public Account(String accountNumber, String accountType, double balance, Bank bank, Customer customer,
			Set<Transactions> transactions) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
		this.bank = bank;
		this.customer = customer;
		this.transactions = transactions;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transactions> transactions) {
		this.transactions = transactions;
	}

//	@Override
//	public String toString() {
//		return "Account [accountNumber=" + accountNumber + ", accountType=" + accountType + ", balance=" + balance
//				+ ", bank=" + bank + ", customer=" + customer + ", transactions=" + transactions + "]";
//	}
	
	
}
