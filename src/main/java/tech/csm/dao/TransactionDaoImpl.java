package tech.csm.dao;

import org.hibernate.Session;

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

}
