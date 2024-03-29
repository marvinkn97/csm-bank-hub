
package tech.csm.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tech.csm.dao.AccountDao;
import tech.csm.dao.AccountDaoImpl;
import tech.csm.dao.TransactionDao;
import tech.csm.dao.TransactionDaoImpl;
import tech.csm.entity.Account;
import tech.csm.entity.Transaction;
import tech.csm.entity.TransactionVO;
import tech.csm.util.BankAppUtil;

public class TransactionServiceImpl implements TransactionService {

	private final AccountDao accountDao;
	private final TransactionDao transactionDao;

	public TransactionServiceImpl() {
		super();
		this.accountDao = new AccountDaoImpl();
		this.transactionDao = new TransactionDaoImpl();
	}

	@Override
	public String saveTransaction(TransactionVO transactionVO) {
		Transaction transaction = new Transaction();
		Character transactionType = null;
		Double amount = Double.parseDouble(transactionVO.getAmount());

		String response = null;

		Account account = accountDao.getAccountByAccountNo(transactionVO.getAccountVO().getAccountNo().toUpperCase());

		if (transactionVO.getTransactionType().equalsIgnoreCase("credit")) {
			if (amount > 0) {
				Double newAccountBal = account.getBalance() + amount;
				account.setBalance(newAccountBal);
				transactionType = transactionVO.getTransactionType().charAt(0);
				response = "Deposit complete";
			}

		} else if (transactionVO.getTransactionType().equalsIgnoreCase("debit")) {

			if (amount > 0 && (account.getBalance() - amount > 0)) {
				Double newAccountBal = account.getBalance() - amount;
				account.setBalance(newAccountBal);
				transactionType = transactionVO.getTransactionType().charAt(0);
				response = "Withdraw complete";
			}

		}
		accountDao.updateAccount(account);

		transaction.setAccount(account);
		transaction.setTransactionDate(new Date());
		transaction.setAmount(amount);
		transaction.setTransactionType(transactionType);

		String msg = transactionDao.saveTransaction(transaction);
		System.out.println(msg);
		return response;
	}

	@Override
	public List<TransactionVO> getTransactionByAccountNo(String accountNumber, int pageSize) {
		List<Transaction> transactionList = transactionDao.getTransactionByAccountNo(accountNumber, pageSize);
		List<TransactionVO> transactionVOList = null;

		if (!transactionList.isEmpty()) {
			transactionVOList = new ArrayList<>();
			for (Transaction x : transactionList) {
				TransactionVO transactionVO = BankAppUtil.mapEntityToVO(x);
				transactionVOList.add(transactionVO);
			}

		}

		return transactionVOList;
	}

}
