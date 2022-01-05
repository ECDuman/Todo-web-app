package com.app.todo;

import static org.mockito.Mockito.when;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.todo.model.User;
import com.app.todo.repository.UserRepository;
import com.app.todo.service.RegistrationService;

@RunWith(SpringRunner.class)
@SpringBootTest
class TodoApplicationTests {

	@Autowired
	private RegistrationService service;
	
	@MockBean
	private UserRepository repo;

	@Test
	public void saveUserTest() {
		User user = new User((long)0, "asd@asd.com", "qwe", "qwe");
		when(repo.save(user)).thenReturn(user);
		assertEquals(user, service.saveUser(user));
	}
	
	@Test
	public void fetchUserByEmailIdTest() {
		String emailId = "asd@asd.com";
		User user = new User((long)0, "asd@asd.com", "qwe", "qwe");
		when(repo.findByEmailId(emailId)).thenReturn(user);
		
		assertEquals(emailId, user.getEmailId());
		
	}
	
	@Test
	public void fetchUserByUserNameTest() {
		String userName = "eren";
		User user = new User((long)0, "asd@asd.com", "eren", "qwe");
		when(repo.findByUserName(userName)).thenReturn(user);
		
		assertEquals(userName, user.getUserName());
		
	}
	
	@Test
	public void fetchUserByEmailIdAndPasswordTest() {
		String emailId = "asd@asd.com";
		String password = "qwe";
		User user = new User((long)0, "asd@asd.com", "qwe", "qwe");
		when(repo.findByEmailIdAndPassword(emailId,password)).thenReturn(user);
		
		assertEquals(emailId, user.getEmailId());
		assertEquals(password, user.getPassword());
		
	}

}
