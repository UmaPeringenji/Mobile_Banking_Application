package com.bank.model;

public class BankT {
	private long acno;
	private String name;
	private String password;
    private long tacno;
	private double amount;
	public BankT() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankT(long acno, String name, String password, long tacno, double amount) {
		super();
		this.acno = acno;
		this.name = name;
		this.password = password;
		this.tacno = tacno;
		this.amount = amount;
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
	public long getTacno() {
		return tacno;
	}
	public void setTacno(long tacno) {
		this.tacno = tacno;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "BankT [acno=" + acno + ", name=" + name + ", password=" + password + ", tacno=" + tacno + ", amount="
				+ amount + "]";
	}

}
