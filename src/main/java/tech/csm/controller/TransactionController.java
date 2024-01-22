package tech.csm.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tech.csm.entity.AccountVO;
import tech.csm.entity.TransactionVO;
import tech.csm.service.AccountService;
import tech.csm.service.AccountServiceImpl;
import tech.csm.service.TransactionService;
import tech.csm.service.TransactionServiceImpl;

public class TransactionController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4050288397271286261L;
	
	private final AccountService accountService;
	private final TransactionService transactionService; 

	public TransactionController() {
		super();
		this.accountService = new AccountServiceImpl();
		this.transactionService = new TransactionServiceImpl();	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String accountNumber = req.getParameter("accNumber");
	    System.out.println(accountNumber);
	    String transactionType = req.getParameter("transactionType");
	    String amount = req.getParameter("amount");
	    
	    TransactionVO transactionVO = new TransactionVO();
	    
	    System.out.println(accountService.getAccountByAccountNo(accountNumber.toUpperCase()));
	    
	    transactionVO.setAccountVO(accountService.getAccountByAccountNo(accountNumber.toUpperCase()));
	    transactionVO.setTransactionType(transactionType);
	    transactionVO.setAmount(amount);
	    
	    String msg = transactionService.saveTransaction(transactionVO);
	    System.out.println(msg);
	    resp.sendRedirect("./getpaymentForm");
	    }
	
	    
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
