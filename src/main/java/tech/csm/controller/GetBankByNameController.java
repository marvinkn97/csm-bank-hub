package tech.csm.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tech.csm.entity.BankVO;
import tech.csm.service.BankService;
import tech.csm.service.BankServiceImpl;

public class GetBankByNameController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3468467406161521535L;
	
	private final BankService bankService;
	
	public GetBankByNameController() {
		super();
		this.bankService = new BankServiceImpl();
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		String bankName = req.getParameter("bankName");
		
		BankVO bankVO = bankService.getBankByName(bankName);
		
		System.out.println(bankVO);
		
		String response =  "<tr>" + "<td>" + 1 + "</td>" + // Serial number
				"<td>" + bankVO.getIfscCode() + "</td>" + "<td>" + bankVO.getBankName() + "</td>" + "</tr>";
		
		resp.getWriter().println(response);
	}

}
