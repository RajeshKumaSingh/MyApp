package com.myapp.service.impl;

import com.myapp.dao.api.LoginDao;
import com.myapp.service.api.LoginService;

public class LoginServiceImpl implements LoginService {
	
	private LoginDao loginDao;	

	
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}


	public boolean validateUser(String userName, String password){
		
		return loginDao.validateUser(userName, password);
	}
}
