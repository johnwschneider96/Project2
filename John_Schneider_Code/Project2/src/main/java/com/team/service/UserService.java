package com.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.model.User;
import com.team.repository.UserDaoImpl;

@Service
public class UserService
{
	@Autowired
	UserDaoImpl userDao;
	
	public void insert(User user) {
		userDao.insert(user);
	}
	
	public void update(User user) {
		userDao.update(user);
	}
	
	public User selectUserByEmail(String email) {
		return userDao.selectUserByEmail(email);
	}
	
	public List<User> selectAllUsers() {
		return userDao.selectAllUsers();
	}
}