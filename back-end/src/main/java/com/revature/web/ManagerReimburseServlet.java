package com.revature.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.models.User;
import com.revature.services.ReimburseService;
import com.revature.utils.ResponseUtil;

/**
 * Servlet implementation class ManagerReimburseServlet
 */
public class ManagerReimburseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReimburseService reimServ = new ReimburseService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerReimburseServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = (User) request.getSession().getAttribute("currentUser");
		if(u == null) {
			response.setStatus(400);
		}
		else {
			ResponseUtil.writeJSON(response, reimServ.viewAllReimbursement());
		};
	}

}
