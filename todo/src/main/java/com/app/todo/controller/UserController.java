package com.app.todo.controller;


import com.app.todo.model.User;
import com.app.todo.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
	
	@Autowired
	private RegistrationService service;
	
	@PostMapping("/registeruser")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		// e-mail unique
		if(tempEmailId != null && !"".equals(tempEmailId)) {
			User userobj = service.fetchUserByEmailId(tempEmailId);
			if(userobj != null) {
				throw new Exception ("user with " + tempEmailId + " is already exist.");
			}
		}
		
		String tempUserName = user.getUserName();
		// username unique
		if(tempUserName != null && !"".equals(tempUserName)) {
			User userobj = service.fetchUserByUserName(tempUserName);
			if(userobj != null) {
				throw new Exception ("user with " + tempUserName + " is already exist.");
			}
		}
		
		
		User userObj = null;
		userObj = service.saveUser(user);
		return userObj;
		
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		String tempPassword = user.getPassword();
		User userObj = null;
		if(tempEmailId != null && tempPassword != null) {
			userObj = service.fetchUserByEmailIdAndPassword(tempEmailId, tempPassword);
			
		}
		if(userObj == null) {
			throw new Exception("Bad credentials");
		}
		return userObj;
	}
}