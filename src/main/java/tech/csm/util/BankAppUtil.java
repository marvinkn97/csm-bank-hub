package tech.csm.util;

import tech.csm.entity.Bank;
import tech.csm.entity.BankVO;

public class BankAppUtil {
	private static int initial = 0;
	public static String generateAccountNumber() {
		return "BKAC000" + ++initial ;
	}

	public static BankVO mapEntityToVO(Bank bank) {
		BankVO bankVO = new BankVO();
		bankVO.setIfscCode(bank.getIfscCode());
		bankVO.setBankName(bank.getBankName());
		return bankVO;
	}

}
