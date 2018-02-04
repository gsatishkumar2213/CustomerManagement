package com.sidgs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.mysql.fabric.Response;
import com.sidgs.bo.CustomerDetailsBo;
import com.sidgs.to.CustomerDetails;

@WebServlet(urlPatterns = "/customers")
public class CustomerListController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CustomerDetailsBo bo = new CustomerDetailsBo();
		List<CustomerDetails> customerList =  bo.getCustomers();
		RequestDispatcher rd = req.getRequestDispatcher("welcome.jsp");
		req.setAttribute("customers", customerList);
		rd.forward(req, resp);
		
	}

	
	


}
