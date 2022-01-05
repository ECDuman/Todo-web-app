package com.app.todo.model;

import javax.persistence.*;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String emailId;
    private String userName;
    private String password;

    public User() {}

    public User(Long id, String emailId, String userName, String password /*, List<Todo> todoList*/) {
		this.id = id;
		this.emailId = emailId;
		this.userName = userName;
		this.password = password;
	}



	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}