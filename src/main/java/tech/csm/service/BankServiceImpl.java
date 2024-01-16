package tech.csm.service;

import java.util.ArrayList;
import java.util.List;

import tech.csm.dao.BankDao;
import tech.csm.dao.BankDaoImpl;
import tech.csm.entity.Bank;
import tech.csm.entity.BankVO;
import tech.csm.util.BankAppUtil;

public class BankServiceImpl implements BankService {

	private final BankDao bankDao;

	public BankServiceImpl() {
		this.bankDao = new BankDaoImpl();
	}

	@Override
	public String addBank(BankVO bankVO) {

		Bank bank = null;
		String response = null;

		if (bankVO != null) {
			bank = new Bank();
			bank.setIfscCode(bankVO.getIfscCode());
			bank.setBankName(bankVO.getBankName());

			response = bankDao.addBank(bank);
		}
		return response;
	}

	@Override
	public List<BankVO> getAllBanks() {
		List<Bank> bankList = bankDao.getAllBanks();
		List<BankVO> bankVoList = null;

		if (!bankList.isEmpty()) {
			bankVoList = new ArrayList<>();

			for (Bank bank : bankList) {
				BankVO bankVO = BankAppUtil.mapEntityToVO(bank);
				bankVoList.add(bankVO);
			}
		}

		return bankVoList;
	}

	@Override
	public BankVO getBankByName(String name) {
		Bank bank = bankDao.getBankByName(name);
	    BankVO bankVO = null;
	    
		if(bank != null && bank.getBankName().equalsIgnoreCase(name)) {
			 bankVO = BankAppUtil.mapEntityToVO(bank);
		}
		return bankVO;
	}

	@Override
	public List<BankVO> getAllBanks(int pageNo, int pageSize) {
		List<Bank> bankList = bankDao.getAllBanks(pageNo, pageSize);
		List<BankVO> bankVoList = null;

		if (!bankList.isEmpty()) {
			bankVoList = new ArrayList<>();

			for (Bank bank : bankList) {
				BankVO bankVO = BankAppUtil.mapEntityToVO(bank);
				bankVoList.add(bankVO);
			}
		}

		return bankVoList;
	}

	@Override
	public Long getTableSize() {
		return bankDao.getTableSize();
	}

}
