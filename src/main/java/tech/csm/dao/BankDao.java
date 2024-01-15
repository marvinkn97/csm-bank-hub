package tech.csm.dao;

import java.util.List;

import tech.csm.entity.Bank;

public interface BankDao {
	
	String addBank(Bank bank);
	List<Bank> getAllBanks();
	Bank getBankByName(String name);
}
