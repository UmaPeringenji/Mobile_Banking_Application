package com.ajp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Feedback {
	
	@Id
	private String feedbackId;
	private String message;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="bankId")
	private Bank bank;

	public Feedback() {
		super();
	}

	public Feedback(String feedbackId, String message, Customer customer, Bank bank) {
		super();
		this.feedbackId = feedbackId;
		this.message = message;
		this.customer = customer;
		this.bank = bank;
	}

	public String getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", message=" + message + ", customer=" + customer + ", bank="
				+ bank + "]";
	}

}
