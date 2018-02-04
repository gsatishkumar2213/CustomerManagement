package com.sidgs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sidgs.bo.UserDetailsBO;
import com.sidgs.exceptions.ApplicationException;
import com.sidgs.to.UserDetails;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		username = request.getParameter("un");
		password = request.getParameter("pw");

		UserDetailsBO bo = new UserDetailsBO();
		UserDetails userdetails = null;
		try {
			userdetails = bo.authenticate(username, password);
			
		} catch (ApplicationException e) {
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("message", e.getMessage());
			rd.forward(request, response);

		}
		if (userdetails != null && userdetails.isValidUser()) {
			RequestDispatcher rd = request.getRequestDispatcher("customers");
			ServletConfig config = getServletConfig();
			request.setAttribute("screenName",config.getInitParameter("screenName"));
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("message", "Incorrect Username or password");
			rd.forward(request, response);

		}

	}

}
