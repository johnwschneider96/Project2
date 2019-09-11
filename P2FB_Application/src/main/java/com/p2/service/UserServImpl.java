package com.p2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p2.model.User;
import com.p2.repository.UserDao;

@Service
public class UserServImpl {

	@Autowired
	UserDao userDao;
	
	public void insertUser(User u) {
		userDao.insert(u);
	}
	
	public void updateUser(User u) {
		userDao.update(u);
	}
	
	public User selectByEmailUser(String email) {
		return userDao.selectByEmail(email);
	}
	
	public List<User> selectAllUsers() {
		return userDao.selectAll();
	}
	
}
