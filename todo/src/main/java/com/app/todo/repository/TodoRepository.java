package com.app.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.todo.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {
	
	public Todo findByContent(String content);
	
}