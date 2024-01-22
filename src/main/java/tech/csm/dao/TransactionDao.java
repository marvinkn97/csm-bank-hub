package tech.csm.dao;

import tech.csm.entity.Transaction;

public interface TransactionDao {
	String saveTransaction(Transaction transaction);
}
