package com.example.todoapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String todo;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "is_completed", nullable = false)
    @JsonProperty("isCompleted")
    private boolean isCompleted;


    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

}