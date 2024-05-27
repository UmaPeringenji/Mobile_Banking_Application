package com.bank.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "bank_tab")
public class Bank {
	@Id
	private long acno;
	private String name;
	private String password;
	private double amount;
	private String address;
	private long mobile;
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bank(long acno, String name, String password, double amount, String address, long mobile) {
		super();
		this.acno = acno;
		this.name = name;
		this.password = password;
		this.amount = amount;
		this.address = address;
		this.mobile = mobile;
	}
	public long getAcno() {
		return acno;
	}
	public void setAcno(long acno) {
		this.acno = acno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Bank [acno=" + acno + ", name=" + name + ", password=" + password + ", amount=" + amount
				+ ", address=" + address + ", mobile=" + mobile + "]";
	}
}
