package tech.csm.service;

import java.util.List;

import tech.csm.entity.TransactionVO;

public interface TransactionService {
	
	String saveTransaction(TransactionVO transactionVO);
	List<TransactionVO> getTransactionByAccountNo(String accountNumber, int pageSize);

}
