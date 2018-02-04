package com.sidgs.bo;

import java.util.List;

import com.sidgs.dao.CustomerDetailsDAO;
import com.sidgs.exceptions.ApplicationException;
import com.sidgs.to.CustomerDetails;

public class CustomerDetailsBo {
	public boolean addCustomer(CustomerDetails customerdetails) throws ApplicationException {
		CustomerDetailsDAO dao = new CustomerDetailsDAO();
		if(customerdetails == null){
			throw new ApplicationException("invalid customer details");
		}
		if(customerdetails.getCustName().isEmpty()){
			throw new ApplicationException("invalid cust name");
		}
		if(customerdetails.getCustEmail().isEmpty()){
			throw new ApplicationException("invalid cust email");
		}
		if(customerdetails.getCustPhone().isEmpty()){
			throw new ApplicationException("invalid cust phone");
		}
		if(customerdetails.getCustAddress().isEmpty()){
			throw new ApplicationException("invalid cust address");
		}
		if(customerdetails.getCustomerAge().isEmpty()){
			throw new ApplicationException("invalid cust age");
		}
		try{
		customerdetails.setCustAge(Integer.parseInt(customerdetails.getCustomerAge()));
		}catch(Exception e){
			throw new ApplicationException("invalid input for age");
		}
		return dao.addCustomer(customerdetails);
	}

	public List<CustomerDetails> getCustomers() {
		CustomerDetailsDAO dao = new CustomerDetailsDAO();
		return dao.getCustomers();
	}
	public CustomerDetails getCustomer(int custId){
		CustomerDetailsDAO dao = new CustomerDetailsDAO();
		return dao.getCustomer(custId);
	}

}
