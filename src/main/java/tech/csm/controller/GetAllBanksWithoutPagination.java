package tech.csm.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tech.csm.entity.BankVO;
import tech.csm.service.BankService;
import tech.csm.service.BankServiceImpl;

public class GetAllBanksWithoutPagination extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2003780177678447194L;
	
	private final BankService bankService;

	public GetAllBanksWithoutPagination() {
		this.bankService = new BankServiceImpl();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

	    List<BankVO> bankVOList = bankService.getAllBanks();

	    String response = "<option value='0'>--SELECT--</option>";

	    for (BankVO x : bankVOList) {
	        response += "<option value=" + x.getBankId() + ">" + x.getBankName() + "</option>";
	    }

	    System.out.println(response);

	    resp.getWriter().println(response);
		
	}

}
