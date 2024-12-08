package com.example.todoapp.repository;

import com.example.todoapp.entity.Todo;
import com.example.todoapp.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Transactional
public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUser(User user);

    void deleteAllByUser(User user);

    Todo findByIdAndUser(Long id, User user); // Added this method
}
