package tech.csm.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetPaymentForm extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4070630756023522685L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    req.getRequestDispatcher("makeTransactionForm.jsp").forward(req, resp);
	}

}
