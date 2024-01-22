package tech.csm.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CheckBalanceForm extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6274640382282126388L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 req.getRequestDispatcher("checkbalance.jsp").forward(req, resp);
	}

}
