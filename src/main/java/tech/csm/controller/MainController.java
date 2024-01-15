package tech.csm.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tech.csm.service.BankService;
import tech.csm.service.BankServiceImpl;
import tech.csm.util.DBUtil;

public class MainController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2935206521395680689L;
	

	@Override
	public void init() throws ServletException {
	     DBUtil.getSessionFactory();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.getWriter().print("main working");
		
	String endpoint = req.getServletPath();
	
	if(endpoint.equals("./")) {
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	else if(endpoint.equals("/getBankForm")) {
		req.getRequestDispatcher("createBankForm.jsp").forward(req, resp);
	}else if(endpoint.equals("/getAccountForm")) {
		req.getRequestDispatcher("createAccountForm.jsp").forward(req, resp);
	}else if(endpoint.equals("/getTransactionForm")) {
		req.getRequestDispatcher("makeTransactionForm.jsp").forward(req, resp);
	}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
