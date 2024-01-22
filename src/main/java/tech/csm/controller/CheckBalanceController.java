package tech.csm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tech.csm.entity.AccountVO;
import tech.csm.service.AccountService;
import tech.csm.service.AccountServiceImpl;

public class CheckBalanceController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2647853232481675846L;
	
	private final AccountService accountService;
	
	
	
	
	public CheckBalanceController() {
		super();
		this.accountService = new AccountServiceImpl();
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accountNumber = req.getParameter("accountNo");

		try {
		    AccountVO accountVO = accountService.getAccountByAccountNo(accountNumber);
		    
		    System.out.println(accountVO);

		    // Convert the account details to JSON format using Jackson
		    ObjectMapper objectMapper = new ObjectMapper();
		    String jsonAccount = objectMapper.writeValueAsString(accountVO);

		    // Set the content type to JSON
		    resp.setContentType("application/json");

		    // Send the JSON response back to the client
		    try (PrintWriter out = resp.getWriter()) {
		        out.print(jsonAccount);
		    }
		} catch (Exception e) {
		    // Handle exceptions
		    e.printStackTrace();

		    // Set an appropriate HTTP status code and response message for the client
		    resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		    resp.setContentType("text/plain");
		    resp.getWriter().write("Error processing the request");
		}
	}
	

}
