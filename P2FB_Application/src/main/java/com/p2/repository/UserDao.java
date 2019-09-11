package com.p2.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.p2.model.User;

/**
 * @author Barton Carson
 * @since 2019-9-11
 */
@Repository("userRepo")
@Transactional
public class UserDao {

	@Autowired
	/**
	 * This session factory holds our current session when accessing our database 
	 */
	private SessionFactory sf;
	
	/**
	 * default constructor
	 */
	public UserDao() {}
	
	/**
	 * @param u the post object you want to enter into the database
	 */
	public void insert(User u) {sf.getCurrentSession().save(u);}
	
	/**
	 * @param u the post object you want to update in the database
	 */
	public void update(User u) {sf.getCurrentSession().update(u);}
	
	/**
	 * @param email the post object you want to enter into the database
	 * @return the user with the selected email
	 */
	public User selectByEmail(String email) {return sf.getCurrentSession().get(User.class, email);}
	
	/**
	 * @return all users in the database
	 */
	public List<User> selectAll() {return sf.getCurrentSession().createQuery("from User", User.class).list();}
	
}
