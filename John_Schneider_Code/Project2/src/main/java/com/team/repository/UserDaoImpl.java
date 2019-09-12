package com.team.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.team.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl
{
	@Autowired
	SessionFactory sesFact;
	
	public void insert(User user) {
		sesFact.getCurrentSession().save(user);
	}
	
	public void update(User user) {
		sesFact.getCurrentSession().update(user);
	}
	
	public User selectUserByEmail(String email) {
		return sesFact.getCurrentSession().get(User.class, email);
	}
	
	public List<User> selectAllUsers() {
		return sesFact.getCurrentSession().createQuery("from User", User.class).list();
	}
}