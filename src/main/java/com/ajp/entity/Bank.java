package com.ajp.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bank {
	
	@Id
	private String bankId;
	private String bankName;
	private String city;
	private int contactNumber;
	
	@OneToMany(mappedBy = "bank",cascade = CascadeType.ALL)
	Set<Account> account=new HashSet<Account>();
	
	@OneToMany(mappedBy = "bank",cascade = CascadeType.ALL)
	List<Feedback> feedback=new ArrayList<Feedback>();

	public Bank() {
		super();
	}

	public Bank(String bankId, String bankName, String city, int contactNumber, Set<Account> account,
			List<Feedback> feedback) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.city = city;
		this.contactNumber = contactNumber;
		this.account = account;
		this.feedback = feedback;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Set<Account> getAccount() {
		return account;
	}

	public void setAccount(Set<Account> account) {
		this.account = account;
	}

	public List<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + ", city=" + city + ", contactNumber="
				+ contactNumber + ", account=" + account + ", feedback=" + feedback + "]";
	}
	
}
