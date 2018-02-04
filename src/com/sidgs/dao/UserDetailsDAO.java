package com.sidgs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sidgs.to.UserDetails;
import com.sidgs.util.ConnectionProvider;

public class UserDetailsDAO {
	public UserDetails authenticate(String username,String password){
		UserDetails userdetails = null;
		String sql = "select * from user_details where emailId=? and password=?";
		try {
			PreparedStatement ps = ConnectionProvider.getConnection().prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				userdetails = new UserDetails();
				userdetails.setUserId(rs.getInt("userId"));
				userdetails.setValidUser(true);
				userdetails.setName(rs.getString("name"));
				userdetails.setEmailId(rs.getString("emailId"));
				userdetails.setPassword(rs.getString("password"));
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userdetails;
		
	}
	public boolean addUser(UserDetails userdetails){
		//Connection connection = ConnectionProvider.getConnection();
		String sql = "INSERT INTO user_details(name,emailId,password) VALUES(?,?,?)";
		try {
			PreparedStatement ps = ConnectionProvider.getConnection().prepareStatement(sql);
			ps.setString(1, userdetails.getName());
			ps.setString(2, userdetails.getEmailId());
			ps.setString(3, userdetails.getPassword());
			if(ps.executeUpdate()>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


}
