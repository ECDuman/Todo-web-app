package com.app.todo;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.Assert.assertEquals;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.todo.model.Todo;
import com.app.todo.repository.TodoRepository;
import com.app.todo.service.TodoService;

@RunWith(SpringRunner.class)
@SpringBootTest
class TodoApplicationTodoTests {

	@Autowired
	private TodoService service;
	
	@MockBean
	private TodoRepository repo;

	@Test
	@Rollback(false)
	public void saveTodoTest() {
		Todo todo = new Todo(1L, "eren", false );
		when(repo.save(todo)).thenReturn(todo);
		assertEquals(todo, service.saveTodo(todo));
	}
	

	@Test
	public void getTodoTest() {

		Todo todo = new Todo(1L, "eren", false );

		Assertions.assertThat(todo.getId()).isEqualTo(1L);
		
	}
	
	@Test
	@Rollback(false)
	public void updateTodoTest() {
		
		Todo todo = new Todo(1L, "eren", false );
		when(repo.findByContent("eren")).thenReturn(todo);
		todo.setContent("duman");
		Todo updatedTodo = todo;
	
		Assertions.assertThat(updatedTodo.getContent()).isEqualTo("duman");

	}
	
	@Test
	@Rollback(false)
	public void deleteTodoTest() {

		Todo todo = new Todo((long)999, "Pranya", false);
		service.saveTodo(todo);
		service.deleteTodo(todo.getId());
		verify(repo, times(1)).deleteById(todo.getId());
		
	}
	
	@Test
	public void fetchTodoByContentTest() {
		String content = "eren";
		Todo todo = new Todo(1L, "eren", true);
		when(repo.findByContent(content)).thenReturn(todo);
		
		assertEquals(content, todo.getContent());
		
	}

}
