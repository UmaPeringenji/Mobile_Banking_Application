package com.bank.service;

import java.util.List;

import com.bank.model.Bank;
import com.bank.model.BankT;
import com.bank.model.BankTemp;

public interface BankService {
	public Bank customerReg(BankTemp banktemp);
	public Bank	getCustmor(Bank bank);
	public Bank depost(Bank bank);
	public Bank withdrawAmount(Bank bank);
	public List<Bank> transferAmt(BankT bank);
	public void deleteAccount(Bank bank);
}
