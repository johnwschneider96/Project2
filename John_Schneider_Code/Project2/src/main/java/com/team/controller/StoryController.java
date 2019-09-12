package com.team.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.model.Story;
import com.team.service.StoryService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class StoryController
{
	@Autowired
	StoryService storyServ;
	
	@PostMapping(value="/insertpost")
	public void insertPost(@RequestParam("new_post") Story story) {
		storyServ.insert(story);
	}
	
	@PostMapping(value="/updatepost")
	public void updatePost(@RequestParam("post") Story story) {
		storyServ.update(story);
	}
	
	@PostMapping(value="/userposts")
	public @ResponseBody List<Story> selectUserPosts(@RequestParam("email") String email) {
		return storyServ.selectStoriesByEmail(email);
	}
	
	@PostMapping(value="/allposts")
	public @ResponseBody List<Story> selectAllPosts() {
		return storyServ.selectAllStories();
	}
}