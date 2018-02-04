package com.sidgs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sidgs.to.CustomerDetails;
import com.sidgs.util.ConnectionProvider;

public class CustomerDetailsDAO {
	public boolean addCustomer(CustomerDetails customerdetails) {
		String sql = "INSERT INTO customer_details(custName,custEmail,custPhone,custAddress, custAge) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps = ConnectionProvider.getConnection().prepareStatement(sql);
			int index = 0;
			ps.setString(++index, customerdetails.getCustName());
			ps.setString(++index, customerdetails.getCustEmail());
			ps.setString(++index, customerdetails.getCustPhone());
			ps.setString(++index, customerdetails.getCustAddress());
			ps.setInt(++index, customerdetails.getCustAge());
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<CustomerDetails> getCustomers() {
		List<CustomerDetails> customerlist = new ArrayList<CustomerDetails>();
		Connection connection = ConnectionProvider.getConnection();
		String sql = "select * from customer_details";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CustomerDetails customer = new CustomerDetails();
				customer.setCustId(rs.getInt("custId"));
				customer.setCustName(rs.getString("custName"));
				customer.setCustEmail(rs.getString("custEmail"));
				customer.setCustPhone(rs.getString("custPhone"));
				customer.setCustAddress(rs.getString("custAddress"));
				customer.setCustAge(rs.getInt("custAge"));
				customerlist.add(customer);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerlist;

	}

	public CustomerDetails getCustomer(int custId) {
		CustomerDetails customer = null;
		Connection connection = ConnectionProvider.getConnection();
		String sql = "select * from Customer_details where custId =?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, custId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				customer = new CustomerDetails();
				customer.setCustId(rs.getInt("custId"));
				customer.setCustName(rs.getString("custName"));
				customer.setCustEmail(rs.getString("custEmail"));
				customer.setCustPhone(rs.getString("custPhone"));
				customer.setCustAddress(rs.getString("custAddress"));
				customer.setCustAge(rs.getInt("custAge"));
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;

		
	}

}
