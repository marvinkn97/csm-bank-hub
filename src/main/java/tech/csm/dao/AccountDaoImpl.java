package tech.csm.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tech.csm.entity.Account;
import tech.csm.util.DBUtil;

public class AccountDaoImpl implements AccountDao {
	@Override
	public String addAccount(Account account) {
		   Session session = DBUtil.getSessionFactory().openSession();
		   Transaction transaction = session.beginTransaction();
		   session.persist(account);
		   transaction.commit();
			session.close();
			return "Account added successfully ";
	}
}
