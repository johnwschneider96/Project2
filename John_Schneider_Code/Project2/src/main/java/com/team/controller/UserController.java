package com.team.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.model.User;
import com.team.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController
{
	@Autowired
	UserService userServ;
	
	@PostMapping(value="/insertuser")
	public void insertPost(@RequestParam("new_user") User u) {
		userServ.insert(u);
	}
	
	@PostMapping(value="/updateuser")
	public void updatePost(@RequestParam("user") User u) {
		userServ.update(u);
	}
	
	@PostMapping(value="/getuserbyemail")
	public @ResponseBody User getUserByEmail(@RequestParam("email") String email) {
		return userServ.selectUserByEmail(email);
	}
	
	@GetMapping(value="/getallusers")
	public @ResponseBody List<User> getAllUsers() {
		return userServ.selectAllUsers();
	}
}