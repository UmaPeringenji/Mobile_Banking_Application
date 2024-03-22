package com.ajp.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	
	@Id
	private String customerId;
	private String customername;
	private String email;
	private LocalDate dob;
	private int phoneNumber;
	private String city;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	Set<Account> account=new HashSet<Account>();
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	Set<Feedback> feedback=new HashSet<Feedback>();

	public Customer() {
		super();
	}

	public Customer(String customerId, String customername, String email, LocalDate dob, int phoneNumber, String city,
			Set<Account> account, Set<Feedback> feedback) {
		super();
		this.customerId = customerId;
		this.customername = customername;
		this.email = email;
		this.dob = dob;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.account = account;
		this.feedback = feedback;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<Account> getAccount() {
		return account;
	}

	public void setAccount(Set<Account> account) {
		this.account = account;
	}

	public Set<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(Set<Feedback> feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customername=" + customername + ", email=" + email + ", dob="
				+ dob + ", phoneNumber=" + phoneNumber + ", city=" + city + ", account=" + account + ", feedback="
				+ feedback + "]";
	}

}
