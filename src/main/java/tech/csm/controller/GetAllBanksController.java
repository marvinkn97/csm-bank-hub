package tech.csm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tech.csm.entity.BankVO;
import tech.csm.service.BankService;
import tech.csm.service.BankServiceImpl;

public class GetAllBanksController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6921904932170390428L;

	private final BankService bankService;

	public GetAllBanksController() {
		this.bankService = new BankServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		int pageSize = 5;
		int pageNo = 0;
		
		if(req.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(req.getParameter("pageNo"));
		}
		
		Long numberOfRecords = bankService.getTableSize();
		
		List<Integer> pageList = new ArrayList<>();
		
		
		for(int i=0, j=1; i< numberOfRecords; i+=pageSize, j++) {
			pageList.add(j);
		}
		
		
		System.out.println("pageSize"+pageSize+"  "+"pageNo="+pageNo);
		req.setAttribute("pageList", pageList);
		
		List<BankVO> bankVOList = bankService.getAllBanks(pageNo, pageSize);
		
		req.setAttribute("bankVOList", bankVOList);
		
		String response = "";
			
		System.out.println(response);

		req.getRequestDispatcher("viewAllBanks.jsp").forward(req, resp);
	}

}
