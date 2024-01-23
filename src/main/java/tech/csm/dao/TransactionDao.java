package tech.csm.dao;

import java.util.List;

import tech.csm.entity.Transaction;

public interface TransactionDao {
	String saveTransaction(Transaction transaction);
	List<Transaction> getTransactionByAccountNo(String accountNumber, int pageSize);
}
