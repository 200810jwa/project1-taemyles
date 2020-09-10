package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.models.User;
import com.revature.models.templates.ReimburseTemplate;
import com.revature.services.ReimburseService;
import com.revature.utils.ResponseUtil;

/**
 * Servlet implementation class ReimburseInfoServlet
 */
public class ReimburseInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReimburseService reimServ = new ReimburseService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReimburseInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
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
			ResponseUtil.writeJSON(response, reimServ.viewReimbursement(u));
		};
	}

}
