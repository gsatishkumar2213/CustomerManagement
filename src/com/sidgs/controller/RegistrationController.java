package com.sidgs.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sidgs.bo.UserDetailsBO;
import com.sidgs.exceptions.ApplicationException;
import com.sidgs.to.UserDetails;


//@WebServlet("/register")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String name;
	private String emailId;
	private String password;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException   {
		name = request.getParameter("name");
		emailId = request.getParameter("mail");
		password = request.getParameter("pw");
		

		UserDetails userdetails = new UserDetails();
		userdetails.setName(name);
		userdetails.setEmailId(emailId);
		userdetails.setPassword(password);

		UserDetailsBO bo= new UserDetailsBO();
		try {
			if(bo.addUser(userdetails)){
				RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
				rd.forward(request, response);

			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("SignUp.jsp");
				request.setAttribute("message","invalid registration or signup");
				rd.forward(request, response);

			}
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			RequestDispatcher rd = request.getRequestDispatcher("SignUp.jsp");
			request.setAttribute("message", e.getMessage());
			rd.forward(request, response);

		}
	}

}
