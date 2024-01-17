package tech.csm.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tech.csm.entity.AccountVO;
import tech.csm.entity.BankVO;
import tech.csm.service.AccountService;
import tech.csm.service.AccountServiceImpl;
import tech.csm.service.BankService;
import tech.csm.service.BankServiceImpl;

public class CreateAccountController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -678577440072808043L;
	
    private final BankService bankService;
    private final AccountService accountService;
    
	public CreateAccountController() {
		super();
		this.bankService = new BankServiceImpl();
		this.accountService = new AccountServiceImpl();
	}
    
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accountName = req.getParameter("accName");
		String phoneNumber = req.getParameter("phoneNo");
		String email = req.getParameter("email");
		String bankId = req.getParameter("bankId");
		String accountType = req.getParameter("accType");

		AccountVO accountVO = new AccountVO();
		accountVO.setName(accountName);
		accountVO.setPhoneNo(phoneNumber);
		accountVO.setEmail(email);
		
		BankVO bankVO = new BankVO();
		bankVO.setBankId(bankId);
		
		accountVO.setBankVO(bankVO);
		
		accountVO.setAccountType(accountType);
		
		String msg = accountService.addAccount(accountVO);
		System.out.println(msg);
		
//		resp.sendRedirect("./");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
