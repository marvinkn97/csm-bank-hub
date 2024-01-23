package tech.csm.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tech.csm.entity.TransactionVO;
import tech.csm.service.TransactionService;
import tech.csm.service.TransactionServiceImpl;

public class MiniStatementController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3462375493580180234L;
	
	private final TransactionService transactionService;

	public MiniStatementController() {
		super();
		this.transactionService = new TransactionServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accountNumber =  req.getParameter("accountNo").toUpperCase();
		System.out.println(accountNumber);
		
		int pageSize = 3;
		
		List<TransactionVO> transactionVOList = transactionService.getTransactionByAccountNo(accountNumber, pageSize);
		
		String response = "";
		
		resp.setContentType("text/html");
		
		for(TransactionVO x : transactionVOList) {
			response += "<tr>"
					+ "<td>" + x.getTransactionId()+ "</td>"
					+ "<td>" + x.getAccountVO().getAccountNo()+ "</td>"
					+ "<td>" + x.getTransactionDate()+ "</td>"
					+ "<td>" + x.getTransactionType()+ "</td>"
					+ "<td>" + x.getAmount()+ "</td>"
					+ "</tr>";
			
		}
		resp.getWriter().println(response);
		System.out.println(response);
		
	}
	

}
