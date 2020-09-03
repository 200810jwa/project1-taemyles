package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.models.templates.LoginTemplate;
import com.revature.services.EmployeeService;
import com.revature.utils.ResponseUtil;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ObjectMapper om = new ObjectMapper();
	private EmployeeService es = new EmployeeService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader reader = request.getReader();
		String body = reader.lines().collect(Collectors.joining());
		LoginTemplate lt = om.readValue(body, LoginTemplate.class);
		Employee e = es.login(lt);
		
		if(e == null) {
			response.setStatus(400);
		} else {
			HttpSession session = request.getSession();
			// This creates a cookie with a single key-value
			// JSESSIONID = something
			// Which represents our session
			
			// Store this employee object on the backend/server corresponding to this session
			session.setAttribute("currentUser", e);
			ResponseUtil.writeJSON(response, e);
		}
	}
}
