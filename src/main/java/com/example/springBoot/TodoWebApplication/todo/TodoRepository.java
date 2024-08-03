package com.example.springBoot.TodoWebApplication.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


// first is which bean it managing and second is the primary key
public interface TodoRepository  extends JpaRepository<Todo, Integer>{
    public List<Todo> findByUsername(String username);
}

