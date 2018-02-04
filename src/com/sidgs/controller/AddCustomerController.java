package com.sidgs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sidgs.bo.CustomerDetailsBo;
import com.sidgs.exceptions.ApplicationException;
import com.sidgs.to.CustomerDetails;

@WebServlet(urlPatterns = "/addCustomer")
public class AddCustomerController extends HttpServlet {
	private String custName;
	private String custEmail;
	private String custPhone;
	private String custAddress;
	private String custAge;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		custName = req.getParameter("custName");
		custEmail = req.getParameter("custEmail");
		custPhone = req.getParameter("custPhone");
		custAddress = req.getParameter("custAddress");
		custAge = req.getParameter("custAge");

		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setCustName(custName);
		customerDetails.setCustEmail(custEmail);
		customerDetails.setCustPhone(custPhone);
		customerDetails.setCustAddress(custAddress);
		customerDetails.setCustomerAge(custAge);

		CustomerDetailsBo bo = new CustomerDetailsBo();
		try {
			if (bo.addCustomer(customerDetails)) {
				RequestDispatcher rd = req.getRequestDispatcher("customers");
				rd.forward(req, resp);
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("addCustomer.jsp");
				req.setAttribute("message", "customer details are incorrect");
				rd.forward(req, resp);
			}
		} catch (ApplicationException e) {
			RequestDispatcher rd = req.getRequestDispatcher("addCustomer.jsp");
			req.setAttribute("message", e.getMessage());
			rd.forward(req, resp);
			
		}
	}

}
