package com.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.Bank;
import com.bank.model.BankT;
import com.bank.model.BankTemp;
import com.bank.repo.BankRepo;
@Service
public class BankServiceImp implements BankService {
	@Autowired
	private BankRepo repo;

	@Override
	public Bank customerReg(BankTemp banktemp) {

		Bank bank=new Bank();
		bank.setAcno(banktemp.getAcno());
		bank.setName(banktemp.getName());
		if(banktemp.getPassword().equals(banktemp.getConfirmpd()))
		{
			bank.setPassword(banktemp.getConfirmpd());
		}
		bank.setAddress(banktemp.getAddress());
		bank.setAmount(banktemp.getAmount());
		bank.setMobile(banktemp.getMobile());
		repo.save(bank);
		return bank;
	}

	@Override
	public Bank getCustmor(Bank bank) {
		Bank bank1=repo.findById(bank.getAcno()).get();
		if(bank.getAcno()==bank1.getAcno()&&bank.getName().equalsIgnoreCase(bank1.getName())&&bank.getPassword().equals(bank1.getPassword()))
		{
		return bank1;
		}
		else
		{
			return null;
		}
	}

	@Override
	public Bank depost(Bank bank) {

		Bank bank1=repo.findById(bank.getAcno()).get();
		
		if(bank.getAcno()==bank1.getAcno()&&bank.getName().equalsIgnoreCase(bank1.getName())&&bank.getPassword().equals(bank1.getPassword()))
		{
			bank1.setAmount(bank1.getAmount()+bank.getAmount());
			repo.save(bank1);	

		return bank1;
		}
		else
		{
			return null;
		}		
	}

	@Override
	public Bank withdrawAmount(Bank bank) {
		
Bank bank1=repo.findById(bank.getAcno()).get();
		
		if(bank.getAcno()==bank1.getAcno()&&bank.getName().equalsIgnoreCase(bank1.getName())&&bank.getPassword().equals(bank1.getPassword()))
		{
			bank1.setAmount(bank1.getAmount()-bank.getAmount());
			repo.save(bank1);	

		return bank1;
		}
		else
		{
			return null;
		}		

		
	}

	@Override
	public List<Bank> transferAmt(BankT bank) {
		Bank b1=repo.findById(bank.getAcno()).get();
		Bank b2= repo.findById(bank.getTacno()).get();
		
		
		if(b1.getAcno()==bank.getAcno()&&b1.getName().equals(bank.getName())&&b1.getPassword().equals(bank.getPassword()))
		{
			
			b1.setAmount(b1.getAmount()-bank.getAmount());
			repo.save(b1);
			
			b2.setAmount(b2.getAmount()+bank.getAmount());
			repo.save(b2);
			
			List<Bank>list=List.of(b1,b2);
			return list;
		}	

		
		return null;
	}

	@Override
	public void deleteAccount(Bank bank) {
		Bank b=repo.findById(bank.getAcno()).get();
		if(b.getAcno()==bank.getAcno()&&b.getName().equals(bank.getName())&&b.getPassword().equals(bank.getPassword()))
		{
			repo.deleteById(bank.getAcno());
		}
	}

}

