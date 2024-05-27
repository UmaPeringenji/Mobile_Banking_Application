package com.bank.model;

public class BankTemp {
	private long acno;
	private String name;
	private String password;
	private String confirmpd;
	private double amount;
	private String address;
	private long mobile;
	public BankTemp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankTemp(long acno, String name, String password, String confirmpd, double amount, String address,
			long mobile) {
		super();
		this.acno = acno;
		this.name = name;
		this.password = password;
		this.confirmpd = confirmpd;
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
	public String getConfirmpd() {
		return confirmpd;
	}
	public void setConfirmpd(String confirmpd) {
		this.confirmpd = confirmpd;
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
		return "BankTemp [acno=" + acno + ", name=" + name + ", password=" + password + ", confirmpd=" + confirmpd
				+ ", amount=" + amount + ", address=" + address + ", mobile=" + mobile + "]";
	}

}
