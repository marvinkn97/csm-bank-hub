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
		return "Account added successfully";
	}

	@Override
	public Account getAccountByAccountNo(String accountNo) {
		Session session = DBUtil.getSessionFactory().openSession();
		
		final String hql = "SELECT a FROM Account a WHERE a.accountNo = :accNo";
		org.hibernate.query.Query<Account> query = session.createQuery(hql);
		query.setParameter("accNo", accountNo);
		
		Account account = query.uniqueResult();
		
		session.close();
		return account;
	}

	@Override
	public String updateAccount(Account account) {
		   Session session = DBUtil.getSessionFactory().openSession();
		    Transaction transaction = session.beginTransaction();

		    try {
		        // Retrieve the existing account from the database
		        Account existingAccount = session.get(Account.class, account.getAccountNo());

		        if (existingAccount != null) {
		            // Update the existing account with the new data
		            existingAccount.setBalance(account.getBalance());
		            // Add other fields as needed

		            // Merge the updated account into the session
		            session.merge(existingAccount);

		            // Commit the transaction
		            transaction.commit();
		            return "Account updated successfully";
		        } else {
		            return "Account not found";
		        }
		    } catch (Exception e) {
		        // Handle exceptions, rollback the transaction if necessary
		        if (transaction != null) {
		            transaction.rollback();
		        }
		        e.printStackTrace(); // Log or handle the exception appropriately
		        return "Error updating account";
		    } finally {
		        // Close the session
		        session.close();
		    }
	}
}
