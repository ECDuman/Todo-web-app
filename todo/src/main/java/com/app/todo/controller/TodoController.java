package com.app.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.todo.model.Todo;
import com.app.todo.service.TodoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {
		
	@Autowired
	private TodoService service;

	@PostMapping("/todos")
	public Todo saveTodo(@RequestBody Todo todo) {
		return service.saveTodo(todo);
	}
		
	@DeleteMapping(value="/todos/{id}")
	public void deleteTodo(@PathVariable Long id) {
		service.deleteTodo(id);
	}
	
	@GetMapping(value="/todos/{id}")
	public Todo getTodo(@PathVariable Long id) {
		return service.getTodo(id);
	}
	
	@PutMapping("/todos")
	public Todo updateTodo(@RequestBody Todo todo) {
		return service.updateTodo(todo);
	}
	
}
