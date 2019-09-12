package com.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.model.Story;
import com.team.repository.StoryDaoImpl;

@Service
public class StoryService
{
	@Autowired
	StoryDaoImpl storyDao;
	
	public void insert(Story story) {
		storyDao.insert(story);
	}
	
	public void update(Story story) {
		storyDao.update(story);
	}
	
	public List<Story> selectStoriesByEmail(String email) {
		return storyDao.selectStoriesByEmail(email);
	}
	
	public List<Story> selectAllStories() {
		return storyDao.selectAllStories();
	}
}