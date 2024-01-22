package tech.csm.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tech.csm.entity.BankVO;
import tech.csm.service.BankService;
import tech.csm.service.BankServiceImpl;

public class CreateBankController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8001585494704422725L;

	private final BankService bankService;

	public CreateBankController() {
		this.bankService = new BankServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BankVO bankVO = new BankVO();
		bankVO.setIfscCode(req.getParameter("ifscCode"));
		System.out.println(req.getParameter("ifscCode"));
		System.out.println(req.getParameter("bankName"));
		bankVO.setBankName(req.getParameter("bankName"));

		String msg = bankService.addBank(bankVO);
		System.out.println(msg);
		
		resp.sendRedirect("./");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
