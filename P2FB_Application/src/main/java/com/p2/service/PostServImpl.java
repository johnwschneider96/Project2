package com.p2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p2.model.Post;
import com.p2.model.User;
import com.p2.repository.PostDao;

@Service
public class PostServImpl {
	
	@Autowired
	PostDao postDao;
	
	public void insert(Post p) {
		postDao.insert(p);
	}
	
	public void update(Post p) {
		postDao.update(p);
	}
	
	public List<Post> selectAllByUser(User u) {
		return postDao.selectAllByUser(u);
	}
	
	public List<Post> selectAll() {
		return postDao.selectAll();
	}
}