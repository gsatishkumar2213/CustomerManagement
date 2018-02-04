package com.sidgs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sidgs.bo.CustomerDetailsBo;
import com.sidgs.to.CustomerDetails;
@WebServlet(urlPatterns="/getCustomer",initParams = {@WebInitParam(name="screenName", value="Customer Detail Info")})
public class CustomerDetailsController extends HttpServlet {
	private int custId;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		custId = Integer.parseInt(req.getParameter("custId"));
		 
		
		CustomerDetailsBo bo = new CustomerDetailsBo();
		CustomerDetails customerDetails = bo.getCustomer(custId);
		RequestDispatcher rd = req.getRequestDispatcher("customerDetails.jsp");
		req.setAttribute("cutomerdetails", customerDetails);
		ServletConfig config = getServletConfig();
		req.setAttribute("screenName", config.getInitParameter("screenName"));
		rd.forward(req, resp); 
	}
	
	

}
