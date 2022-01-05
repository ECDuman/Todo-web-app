import { Component, OnInit } from '@angular/core';
import { Todo } from '../todo';
import { HttpClient } from '@angular/common/http';
import { TodoDialog } from '../dialogs/todo-dialog';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-todos',
  templateUrl: './todos.component.html',
  styleUrls: ['./todos.component.css'],
})
export class TodosComponent implements OnInit {
  todos: Todo[] = [];

  constructor(private todoDialogRef: MatDialog, private http: HttpClient) {}

  ngOnInit() {}

  onNewTodoClick(): void {
    let dialogRef = this.todoDialogRef.open(TodoDialog, {
      data: {
        content: 'Create new Todo',
      },
    });

    dialogRef.afterClosed().subscribe((result) => {
      console.log(result);
      if (result) {
        if (result.content) {
          console.log('saving new todo');
          this.saveNewTodo(result);
        }
      }
    });
  }

  getUncompletedTodos(): Todo[] {
    return this.todos.filter((todo) => !todo.completed);
  }

  getCompletedTodos(): Todo[] {
    return this.todos.filter((todo) => todo.completed);
  }

  todoCompleted(index: number, isComplete: boolean): void {
    let todo = this.todos[index];
    todo.completed = isComplete;
    this.updateTodo(todo);
  }

  saveNewTodo(todo: Todo) {
    this.http
      .post<Todo>('http://localhost:8080/todos', todo)
      .subscribe((response) => {
        console.log(response);
        this.todos.push(response);
      });
  }

  updateTodo(todo: Todo): void {
    let uri = `http://localhost:8080/todos/`;
    this.http.put(uri, todo).subscribe((result) => {
      console.log(result);
    });
  }

  deleteTodo(index: number): void {
    let todo = this.todos[index];
    let uri = `http://localhost:8080/todos/${todo.id}`;
    this.http.delete(uri).subscribe((result) => {
      this.todos.splice(index, 1);
    });
  }
}
