package tech.csm.service;

import java.util.List;

import tech.csm.entity.BankVO;

public interface BankService {
	
	String addBank(BankVO bankVO);
	List<BankVO> getAllBanks();
	List<BankVO> getAllBanks(int pageNo, int pageSize);
	Long getTableSize();
	BankVO getBankByName(String name);
}
