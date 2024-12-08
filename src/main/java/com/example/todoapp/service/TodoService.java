package com.example.todoapp.service;

import com.example.todoapp.entity.Todo;
import com.example.todoapp.entity.User;
import com.example.todoapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserService userService;

    public Todo createTodo(Todo todo, String username) {
        User user = userService.findByUsername(username);
        todo.setUser(user);
        todo.setCreatedAt(LocalDateTime.now());
        return todoRepository.save(todo);
    }

    public List<Todo> getTodosByUsername(String username) {
        User user = userService.findByUsername(username);
        return todoRepository.findByUser(user);
    }

    public Todo updateTodo(Long id, Map<String, Object> updates, User user) {
        Todo todo = todoRepository.findByIdAndUser(id, user);
        if (updates.containsKey("todo")) {
            todo.setTodo((String) updates.get("todo"));
        }
        if (updates.containsKey("isCompleted")) {
            todo.setCompleted((Boolean) updates.get("isCompleted"));
        }
        return todoRepository.save(todo);
    }


    public void deleteTodoByUser(String username, Long id) {
        User user = userService.findByUsername(username);
        Todo todo = todoRepository.findByIdAndUser(id, user);
        if (todo != null) {
            todoRepository.delete(todo);
        }
    }

    public void deleteAllTodosByUser(String username) {
        User user = userService.findByUsername(username);
        todoRepository.deleteAllByUser(user);
    }

}
