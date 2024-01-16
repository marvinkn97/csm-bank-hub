package tech.csm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import tech.csm.entity.Bank;
import tech.csm.util.DBUtil;

public class BankDaoImpl implements BankDao {
	@Override
	public String addBank(Bank bank) {

		Session session = DBUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(bank);
		transaction.commit();
		session.close();
		return "Bank added successfully ";
	}

	@Override
	public List<Bank> getAllBanks() {
		Session session = DBUtil.getSessionFactory().openSession();
		final String hql = "SELECT b FROM Bank b";

		Query<Bank> query = session.createQuery(hql);
		List<Bank> bankList = query.list();

		session.close();
		return bankList;
	}

	@Override
	public Bank getBankByName(String name) {
		Session session = DBUtil.getSessionFactory().openSession();
		final String hql = "SELECT b FROM Bank b WHERE b.bankName = :bankName";

		Query<Bank> query = session.createQuery(hql);
		query.setParameter("bankName", name);

		Bank bank = query.uniqueResult();

		session.close();
		return bank;
	}

	@Override
	public List<Bank> getAllBanks(int pageNo, int pageSize) {
		Session session = DBUtil.getSessionFactory().openSession();
		final String hql = "SELECT b FROM Bank b";
		
		Query<Bank> query = session.createQuery(hql);
		System.out.println("pageNo = "+ pageNo + " " + "pageSize = " + pageSize);
		
		query.setFirstResult(pageNo * pageSize);
		query.setMaxResults(pageSize);
		
		List<Bank> bankList = query.list();

		session.close();
		return bankList;
	}

	@Override
	public Long getTableSize() {
		Session session = DBUtil.getSessionFactory().openSession();
		final String hql = "SELECT count(*) FROM Bank";

		Query<Long> query = session.createQuery(hql);
		Long noOfRows = query.uniqueResult();
		session.close();

		return noOfRows;
	}

}
