package tech.csm.service;

import tech.csm.dao.AccountDao;
import tech.csm.dao.AccountDaoImpl;
import tech.csm.dao.BankDao;
import tech.csm.dao.BankDaoImpl;
import tech.csm.entity.Account;
import tech.csm.entity.AccountVO;
import tech.csm.entity.Bank;
import tech.csm.util.BankAppUtil;

public class AccountServiceImpl implements AccountService {

	private final AccountDao accountDao;
	private final BankDao bankDao;

	public AccountServiceImpl() {
		super();
		this.accountDao = new AccountDaoImpl();
		this.bankDao = new BankDaoImpl();
	}

	@Override
	public String addAccount(AccountVO accountVO) {

		Account account = null;
		String response = null;

		if (accountVO != null) {
			account = new Account();

			account.setAccountNo(BankAppUtil.generateAccountNumber());
			account.setName(accountVO.getName());
			account.setEmail(accountVO.getEmail());
			account.setPhoneNo(accountVO.getPhoneNo());

			Bank bank = bankDao.getBankById(Integer.parseInt(accountVO.getBankVO().getBankId()));

			account.setBank(bank);

			account.setAccountType(accountVO.getAccountType());
			account.setBalance(0.0);

			response = accountDao.addAccount(account);

		}

		return response;
	}

	@Override
	public AccountVO getAccountByAccountNo(String accountNo) {
		Account account = accountDao.getAccountByAccountNo(accountNo);
		
		AccountVO accountVO = BankAppUtil.mapEntityToVO(account);
		
		return accountVO;
	}

}
