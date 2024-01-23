package tech.csm.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

        switch (endpoint) {
            case "/getBankForm":
                req.getRequestDispatcher("createBankForm.jsp").forward(req, resp);
                break;
            case "/getAccountForm":
                req.getRequestDispatcher("/getAccountForm").forward(req, resp);
                break;
            case "/getTransactionForm":
                req.getRequestDispatcher("/getpaymentForm").forward(req, resp);
                break;
            case "/getbalance":
                req.getRequestDispatcher("/getbalance").forward(req, resp);
                break;
            case "/getministmt":
                req.getRequestDispatcher("/getministmt").forward(req, resp);
                break;
            case "/getfullstmt":
                req.getRequestDispatcher("/getfullstmt").forward(req, resp);
                break;
        }
      
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
