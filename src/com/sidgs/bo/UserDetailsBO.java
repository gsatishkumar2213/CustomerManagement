package com.sidgs.bo;

import com.sidgs.dao.UserDetailsDAO;
import com.sidgs.exceptions.ApplicationException;
import com.sidgs.to.UserDetails;

public class UserDetailsBO {
	public UserDetails authenticate(String username, String password) throws ApplicationException {
		UserDetailsDAO dao = new UserDetailsDAO();
		if (username == null || username.isEmpty()) {
			throw new ApplicationException("Invalid username");

		}
		if(password == null || password.isEmpty()){
			throw new ApplicationException("invalid password");
		}
		return dao.authenticate(username, password);

	}

	public boolean addUser(UserDetails userdetails) throws ApplicationException {
		UserDetailsDAO dao = new UserDetailsDAO();
		if (userdetails == null) {
			throw new ApplicationException("invalid userDetails");
		}
		if (userdetails.getName() == null || userdetails.getName().isEmpty()) {
			throw new ApplicationException("invalid username");
		}
		if (userdetails.getEmailId() == null || userdetails.getEmailId().isEmpty()) {
			throw new ApplicationException("invalid user email");
		}
		if (userdetails.getPassword() == null || userdetails.getPassword().isEmpty()) {
			throw new ApplicationException("invalid password");
		}
		return dao.addUser(userdetails);
	}

}
