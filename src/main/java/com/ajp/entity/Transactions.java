package com.ajp.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transactions {
	
	@Id
	private String transactionId;
	private Double transactionAmount;
	private String transactionType;
	private LocalDate transactionDate;
	
	@ManyToOne
	@JoinColumn(name="accountNumber")
	private Account account;

	public Transactions() {
		super();
	}

	public Transactions(String transactionId, Double transactionAmount, String transactionType,
			LocalDate transactionDate, Account account) {
		super();
		this.transactionId = transactionId;
		this.transactionAmount = transactionAmount;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.account = account;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "TransactionService [transactionId=" + transactionId + ", transactionAmount=" + transactionAmount
				+ ", transactionType=" + transactionType + ", transactionDate=" + transactionDate + ", account="
				+ account + "]";
	}
}
