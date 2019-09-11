package com.p2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p2.model.User;

@Service
public class UserServImpl {

	@Autowired
	UserServImpl userDao;
	
	public void insertUser(User u) {
		//return userDao.insert(u);
	}
	
}
