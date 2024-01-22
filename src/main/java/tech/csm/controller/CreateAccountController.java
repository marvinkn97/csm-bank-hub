package tech.csm.controller;

import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tech.csm.entity.AccountVO;
import tech.csm.entity.BankVO;
import tech.csm.service.AccountService;
import tech.csm.service.AccountServiceImpl;

public class CreateAccountController extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = -678577440072808043L;

    private final AccountService accountService;

    public CreateAccountController() {
        this.accountService = new AccountServiceImpl();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            System.out.println(paramName + ": " + req.getParameter(paramName));
        }


        String accountName = req.getParameter("accName");
        String phoneNumber = req.getParameter("phoneNo");
        String email = req.getParameter("email");
        String bankId = req.getParameter("bankId");
        String accountType = req.getParameter("accountType");

//		System.out.println(accountName + " " + phoneNumber + " " + email + " " + bankId + " " + accountType);

        AccountVO accountVO = new AccountVO();
        accountVO.setName(accountName);
        accountVO.setPhoneNo(phoneNumber);
        accountVO.setEmail(email);

        BankVO bankVO = new BankVO();
        bankVO.setBankId(bankId);

        accountVO.setBankVO(bankVO);

        accountVO.setAccountType(accountType);

//		System.out.println(accountVO);

        String msg = accountService.addAccount(accountVO);
        System.out.println(msg);

        resp.sendRedirect("./");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
