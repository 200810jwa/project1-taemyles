package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.models.templates.ManagerReimburseTemplate;
import com.revature.services.ReimburseService;

/**
 * Servlet implementation class ManagerApprovalServlet
 */
public class ManagerApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ObjectMapper om = new ObjectMapper();
	private ReimburseService reimServ = new ReimburseService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerApprovalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader reader = request.getReader();
		String body = reader.lines().collect(Collectors.joining());
		User u = (User) request.getSession().getAttribute("currentUser");
		if(u == null) {
			response.setStatus(400);
		}
		else {
			ManagerReimburseTemplate reim = om.readValue(body, ManagerReimburseTemplate.class);
			reimServ.updateReimbursement(u, reim);
		}
	}

}
