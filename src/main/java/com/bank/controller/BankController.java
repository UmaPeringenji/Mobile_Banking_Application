package com.bank.controller;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.ModelMap;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;

	import com.bank.model.Bank;
	import com.bank.model.BankT;
	import com.bank.model.BankTemp;
	import com.bank.service.BankService;

	import java.util.List;

	@Controller
	public class BankController {
	@Autowired
	private BankService service;
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}

	@RequestMapping("/reg")
	public String regPage(ModelMap model,BankTemp banktemp)
	{
		model.put("banktemp", banktemp);
		return "reg";
	}


	@RequestMapping("/register")
	public String regCustomer(@ModelAttribute BankTemp banktemp,ModelMap model)
	{	service.customerReg(banktemp);
		return "success";
	}

	@RequestMapping("/balance")
	public String balance(ModelMap model,Bank bank)
	{
		model.addAttribute("command", bank);
		return "balance";
	}
	@RequestMapping("/checkbal")
	public String  checkBalance(@ModelAttribute Bank bank,ModelMap model) 
	{
		Bank b= service.getCustmor(bank);
		model.addAttribute("bank",b);
		return "viewbalance";
	}

	@RequestMapping("/deposit")
	public String deposit(ModelMap model,Bank bank)
	{
		model.addAttribute("bank", bank);
		return "deposit";
	}


	@RequestMapping("/depositamt")
	public String  depositAmt(@ModelAttribute Bank bank, ModelMap model) 
	{
		Bank bank1=service.depost(bank);
		model.put("orgbal", bank1.getAmount()-bank.getAmount());
		model.put("deposit", bank.getAmount());
		model.put("afterdep", bank1.getAmount());
		
		return "depositsuccess";
	}


	@RequestMapping("/withdraw")
	public String withdrawPage(ModelMap model,Bank bank)
	{
		model.addAttribute("bank", bank);
		return "withdraw";
	}

	@RequestMapping("/withdrawamt")
	public String  withdrawAmt(@ModelAttribute Bank bank, ModelMap model) 
	{
		Bank bank1=service.withdrawAmount(bank);
		model.put("orgbal", bank1.getAmount()+bank.getAmount());
		model.put("withdraw", bank.getAmount());
		model.put("afterwith", bank1.getAmount());
		
		return "withdrawSuccess";
	}


	@RequestMapping("/transfer")
	public String transferPage(ModelMap model,BankT bank)
	{
		model.addAttribute("bank", bank);
		return "transfer";
	}

	@RequestMapping("/transferamt")
	public String transferAmt(@ModelAttribute BankT bank, ModelMap model)
	{
		List<Bank>lists=service.transferAmt(bank);
		
		model.put("aa",lists.get(0).getAmount()+bank.getAmount());
		model.put("bb",lists.get(0).getAmount());
		
		model.put("dd",lists.get(1).getAmount());
		model.put("cc",lists.get(1).getAmount()-bank.getAmount());

		
		
		return "transfersuccess";
	}
	@RequestMapping("/close")
	public String closeForm(ModelMap model,Bank bank)
	{	model.addAttribute("bank", bank);
		return "close";
	}

	@RequestMapping("/closeact")
	public String closePage(@ModelAttribute Bank bank,ModelMap model)
	{	service.deleteAccount(bank);
		return "closeSuccess";
	}


	@RequestMapping("/about")
	public String aboutPage()
	{
		return "about";
	}

}
