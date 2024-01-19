package tech.csm.util;

import java.util.Random;

import tech.csm.entity.Account;
import tech.csm.entity.AccountVO;
import tech.csm.entity.Bank;
import tech.csm.entity.BankVO;

public class BankAppUtil {
	public static String generateAccountNumber() {
		return "BKACC" + new Random().nextInt(1000, 9999) ;
	}

	public static BankVO mapEntityToVO(Bank bank) {
		BankVO bankVO = new BankVO();
		bankVO.setBankId(bank.getBankId().toString());
		bankVO.setIfscCode(bank.getIfscCode());
		bankVO.setBankName(bank.getBankName());
		return bankVO;
	}
	
	public static AccountVO mapEntityToVO(Account account) {
		return null;
	}

}
