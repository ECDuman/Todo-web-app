package com.app.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.todo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	
	public User findByEmailId(String emailId);
	public User findByUserName(String userName);
	public User findByEmailIdAndPassword(String emailId, String password);
}