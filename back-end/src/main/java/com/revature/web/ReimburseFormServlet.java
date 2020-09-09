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
import com.revature.models.templates.ReimburseTemplate;
import com.revature.services.ReimburseService;

/**
 * Servlet implementation class ReimburseFormServlet
 */
public class ReimburseFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ObjectMapper om = new ObjectMapper();
	private ReimburseService reimServ = new ReimburseService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReimburseFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
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
			ReimburseTemplate reim = om.readValue(body, ReimburseTemplate.class);
			reimServ.addReimbursement(u, reim);
		}
	}
}
