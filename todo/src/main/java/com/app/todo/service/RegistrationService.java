package com.app.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.todo.model.User;
import com.app.todo.repository.UserRepository;

@Service
public class RegistrationService {

	@Autowired
	private UserRepository repo;
	
	public User saveUser(User user) {
		return repo.save(user);
	}
	
	public User fetchUserByEmailId(String emailId) {
		return repo.findByEmailId(emailId);
	}
	
	public User fetchUserByUserName(String userName) {
		return repo.findByUserName(userName);
	}
	
	public User fetchUserByEmailIdAndPassword(String emailId, String password) {
		return repo.findByEmailIdAndPassword(emailId,password);
	}

}
