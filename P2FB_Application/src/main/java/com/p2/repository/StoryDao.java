package com.p2.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.p2.model.Story;

/**
 * Story Dao for accessing the database
 * 
 * @author Barton Carson & John Schneider
 * @since 2019-9-13
 */
@Repository("storyRepo")
@Transactional
public class StoryDao {
	
	/**
	 * Autowired session factory for the story dao
	 */
	@Autowired
	SessionFactory sesFact;
	
	/**
	 * default constructor
	 */
	public StoryDao() {}
	
	/**
	 * Dao method that inserts the story into the database
	 * 
	 * @param s the story object in the database
	 */
	public void insert(Story s) {sesFact.getCurrentSession().save(s);}
	
	/**
	 * Dao method that updates the story in the database
	 * 
	 * @param s the story object in the database
	 */
	public void update(Story s) {sesFact.getCurrentSession().update(s);}
	
	/**
	 * Dao method that selects all stories based on the user email from the database
	 * 
	 * @param email from the user that created the story
	 * @return all stories for the given user email from the database
	 */
	public List<Story> selectStoriesByEmail(String email) {return sesFact.getCurrentSession().createQuery("FROM Story WHERE email=" + email, Story.class).list();}
	
	/**
	 * Dao method that selects all stories for all users from the database
	 * 
	 * @return all stories for all users from the database
	 */
	public List<Story> selectAllStories() {return sesFact.getCurrentSession().createQuery("FROM Story", Story.class).getResultList();}
}