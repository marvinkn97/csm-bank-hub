package tech.csm.util;

import java.text.SimpleDateFormat;
import java.util.Random;

import tech.csm.entity.Account;
import tech.csm.entity.AccountVO;
import tech.csm.entity.Bank;
import tech.csm.entity.BankVO;
import tech.csm.entity.TransactionVO;
import tech.csm.entity.Transaction;

public class BankAppUtil {
	public static String generateAccountNumber() {
		return "BKACC" + new Random().nextInt(1000, 9999);
	}

	public static BankVO mapEntityToVO(Bank bank) {
		BankVO bankVO = new BankVO();
		bankVO.setBankId(bank.getBankId().toString());
		bankVO.setIfscCode(bank.getIfscCode());
		bankVO.setBankName(bank.getBankName());
		return bankVO;
	}

	public static AccountVO mapEntityToVO(Account account) {

		AccountVO accountVO = new AccountVO();
		accountVO.setAccountType(account.getAccountType().toLowerCase());
		accountVO.setBalance(account.getBalance().toString());
		accountVO.setBankVO(mapEntityToVO(account.getBank()));
		accountVO.setName(account.getName());
		accountVO.setPhoneNo(account.getPhoneNo());
		accountVO.setEmail(account.getEmail());
		accountVO.setAccountNo(account.getAccountNo());

		return accountVO;
	}

	public static TransactionVO mapEntityToVO(Transaction transaction) {
		TransactionVO transactionVO = new TransactionVO();
		transactionVO.setAccountVO(mapEntityToVO(transaction.getAccount()));
		transactionVO.setAmount(transaction.getAmount().toString());
		transactionVO.setTransactionDate(new SimpleDateFormat("yyy-MM-dd").format(transaction.getTransactionDate()));
		transactionVO.setTransactionId(transaction.getTransactionId().toString());
		transactionVO.setTransactionType(String.valueOf(transaction.getTransactionType()));

		return transactionVO;
	}
}
