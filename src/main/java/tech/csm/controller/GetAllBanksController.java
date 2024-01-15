package tech.csm.controller;

import java.io.IOException;
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
		List<BankVO> bankVOList = bankService.getAllBanks();

		String response = "";
		
	
		   // Retrieve the session from the request, create a new one if it doesn't exist
	    HttpSession session = req.getSession(true);

	    // Retrieve the initial value from the session, or set it to 1 if not present
	    Integer initial = (Integer) session.getAttribute("initial");
	    if (initial == null) {
	        initial = 1;
	        session.setAttribute("initial", initial);
	    }

		for (BankVO bankVO : bankVOList) {

			response += "<tr>" + "<td>" + initial++ + "</td>" + // Serial number
					"<td>" + bankVO.getIfscCode() + "</td>" + "<td>" + bankVO.getBankName() + "</td>" + "</tr>";
		}
		
		System.out.println(response);

		resp.getWriter().println(response);
	}

}
