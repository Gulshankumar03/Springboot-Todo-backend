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
@RequestMapping("/api/users/{username}/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getTodos(@PathVariable String username) {
        List<Todo> todos = todoService.getTodosByUsername(username);
        return ResponseEntity.ok(todos);
    }

    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody Todo todo, @PathVariable String username) {
        Todo createdTodo = todoService.createTodo(todo, username);
        return ResponseEntity.ok(createdTodo);
    }


    @PutMapping("/{id}")
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


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable String username, @PathVariable Long id) {
        todoService.deleteTodoByUser(username, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/all")
    public ResponseEntity<?> deleteAllTodos(@PathVariable String username) {
        todoService.deleteAllTodosByUser(username);
        return ResponseEntity.ok().build();
    }
}
