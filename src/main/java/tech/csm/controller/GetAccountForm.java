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

public class GetAccountForm extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2215866388346132239L;

	private final BankService bankService;

	public GetAccountForm() {
		this.bankService = new BankServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		List<BankVO> bankVOList = bankService.getAllBanks();

		req.setAttribute("bankVOList", bankVOList);

		req.getRequestDispatcher("createAccountForm.jsp").forward(req, resp);

	}

}
