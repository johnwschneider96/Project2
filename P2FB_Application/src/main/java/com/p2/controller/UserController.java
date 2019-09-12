package com.p2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.p2.model.User;
import com.p2.service.UserServImpl;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController
{
	@Autowired
	UserServImpl userServ;
	
	@PostMapping(value="/insertuser")
	public void insertPost(@RequestParam("new_user") User u) {
		userServ.insertUser(u);
	}
	
	@PostMapping(value="/updateuser")
	public void updatePost(@RequestParam("user") User u) {
		userServ.updateUser(u);
	}
	
	@PostMapping(value="/getuserbyemail")
	public @ResponseBody User getUserByEmail(@RequestParam("email") String email) {
		return userServ.selectByEmailUser(email);
	}
	
	@PostMapping(value="/getallusers")
	public @ResponseBody List<User> getAllUsers() {
		return userServ.selectAllUsers();
	}
}