package tech.csm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import tech.csm.entity.Transaction;
import tech.csm.util.DBUtil;

public class TransactionDaoImpl implements TransactionDao {

	@Override
	public String saveTransaction(Transaction transaction) {

		Session session = DBUtil.getSessionFactory().openSession();
		org.hibernate.Transaction t = session.beginTransaction();
		session.persist(transaction);
		t.commit();
		session.close();

		return "Transaction complete";
	}

	@Override
	public List<Transaction> getTransactionByAccountNo(String accountNumber, int pageSize) {
		Session session = DBUtil.getSessionFactory().openSession();

		final String hql = "SELECT t FROM Transaction t WHERE t.account.accountNo = :accountNo ORDER BY t.transactionDate DESC";

		Query<Transaction> query = session.createQuery(hql);
		query.setParameter("accountNo", accountNumber);

		query.setMaxResults(pageSize);

		List<Transaction> studentList = query.list();

		session.close();
		return studentList;
	}

}
