package com.example.todoapp.controller;

import com.example.todoapp.entity.Todo;
import com.example.todoapp.entity.User;
import com.example.todoapp.service.TodoService;
import com.example.todoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getRootResponse() {
        return "welcome to TaskMate.";
    }

    @GetMapping("/api/users/{username}/todos")
    public ResponseEntity<?> getTodos(@PathVariable String username) {
        List<Todo> todos = todoService.getTodosByUsername(username);
        return ResponseEntity.ok(todos);
    }

    @PostMapping("/api/users/{username}/todos")
    public ResponseEntity<?> createTodo(@RequestBody Todo todo, @PathVariable String username) {
        Todo createdTodo = todoService.createTodo(todo, username);
        return ResponseEntity.ok(createdTodo);
    }


    @PutMapping("/api/users/{username}/todos/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable String username,
                                        @PathVariable Long id,
                                        @RequestBody Map<String, Object> updates) {
        User user = userService.findByUsername(username);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        Todo updatedTodo = todoService.updateTodo(id, updates, user);
        return ResponseEntity.ok(updatedTodo);
    }


    @DeleteMapping("/api/users/{username}/todos/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable String username, @PathVariable Long id) {
        todoService.deleteTodoByUser(username, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/api/users/{username}/todos/all")
    public ResponseEntity<?> deleteAllTodos(@PathVariable String username) {
        todoService.deleteAllTodosByUser(username);
        return ResponseEntity.ok().build();
    }
}
