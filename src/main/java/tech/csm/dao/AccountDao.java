package tech.csm.dao;

import tech.csm.entity.Account;

public interface AccountDao {
	String addAccount(Account account);
	Account getAccountByAccountNo(String accountNo);
	String updateAccount(Account account);
}
