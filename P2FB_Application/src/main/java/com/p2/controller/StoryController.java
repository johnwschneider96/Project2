package com.p2.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.p2.model.Story;
import com.p2.service.StoryService;

/**
 * Story Controller for accepting and sending data to the front-end angular application
 * 
 * @author Barton Carson
 * @since 2019-9-13
 */
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class StoryController {
	
	/**
	 * Autowired story service for the story controller
	 */
	@Autowired
	StoryService storyServ;
	
	/**
	 * Insert controller method that inserts the story into the database
	 * 
	 * @param story the story object in the database
	 */
	@PostMapping(value = "/insertuser")
	public void insertPost(@RequestBody String jsonString) {
		Story s = null;
		try {
			s = new ObjectMapper().readValue(jsonString, Story.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		storyServ.insert(s);
	}
	
	/**
	 * Controller method that updates the story in the database
	 * 
	 * @param story the story object in the database
	 */
	@PostMapping(value = "/updateuser")
	public void updatePost(@RequestBody String jsonString) {
		Story s = null;
		try {
			s = new ObjectMapper().readValue(jsonString, Story.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		storyServ.update(s);;
	}
	
	/**
	 * Controller method that selects all storys based on the user email
	 * 
	 * @param email from the user that created the post
	 * @return all posts for the given user
	 */
	@GetMapping(value="/userposts")
	public @ResponseBody List<Story> selectUserPosts(@RequestParam("email") String email) {
		return storyServ.selectStoriesByEmail(email);
	}
	
	/**
	 * Controller method that selects all storys from all users
	 * 
	 * @return all posts from all users
	 */
	@GetMapping(value="/allposts")
	public @ResponseBody List<Story> selectAllPosts() {
		return storyServ.selectAllStories();
	}
}