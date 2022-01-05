package com.app.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.todo.model.Todo;
import com.app.todo.repository.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository repo;


	public Todo saveTodo(Todo todo) {
		return repo.save(todo);
	}
	
	public void deleteTodo(Long id) {
		repo.deleteById(id);
	}
	public Todo getTodo(Long id) {
		return repo.findById(id).get();
	}
	public Todo updateTodo(Todo todo) {
		Todo existingTodo = repo.findById(todo.getId()).orElse(null);
        if(existingTodo.equals(null))
            return  null;
        existingTodo.setId(todo.getId());
        existingTodo.setContent(todo.getContent());
        existingTodo.setCompleted(todo.getCompleted());
        return repo.save(existingTodo);
	}
	public Todo fetchTodoByContent(String content) {
		return repo.findByContent(content);
	}

	
}
