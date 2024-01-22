package tech.csm.service;

import tech.csm.entity.AccountVO;

public interface AccountService {
	String addAccount(AccountVO accountVO);
	AccountVO getAccountByAccountNo(String accountNo);

}
