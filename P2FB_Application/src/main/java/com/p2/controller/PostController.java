package com.p2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.p2.model.Post;
import com.p2.model.User;
import com.p2.service.PostServImpl;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class PostController
{
	@Autowired
	PostServImpl postServ;
	
	@PostMapping(value="/insertpost")
	public void insertPost(@RequestParam("new_post") Post p) {
		postServ.insert(p);
	}
	
	@PostMapping(value="/updatepost")
	public void updatePost(@RequestParam("post") Post p) {
		postServ.update(p);
	}
	
	@PostMapping(value="/userposts")
	public @ResponseBody List<Post> selectUserPosts(@RequestParam("user") User u) {
		return postServ.selectAllByUser(u);
	}
	
	@PostMapping(value="/allposts")
	public @ResponseBody List<Post> selectAllPosts() {
		return postServ.selectAll();
	}
}