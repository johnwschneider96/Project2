package com.team.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.team.model.Story;

@Repository("storyDao")
@Transactional
public class StoryDaoImpl
{
	@Autowired
	SessionFactory sesFact;
	
	public void insert(Story story) {
		sesFact.getCurrentSession().save(story);
	}
	
	public void update(Story story) {
		sesFact.getCurrentSession().update(story);
	}
	
	public List<Story> selectStoriesByEmail(String email) {
		return sesFact.getCurrentSession().createQuery("from Story where email="+email, Story.class).list();
	}
	
	public List<Story> selectAllStories() {
		return sesFact.getCurrentSession().createQuery("from Story", Story.class).getResultList();
	}
}
