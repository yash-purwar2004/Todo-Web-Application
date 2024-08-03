package com.example.springBoot.TodoWebApplication.todo;
import java.util.ArrayList;
import java.util.List;

import java.util.function.Predicate;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

import java.time.LocalDate;
// To manage Todos Statically
@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;
    static {
        todos.add(new Todo(++todosCount, "yashpurwar2004", "Learn AWS now", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "yashpurwar2004", "Learn DevOps now", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todosCount, "yashpurwar2004", "Learn Full Stack now", LocalDate.now().plusYears(3), false));
    }


    public void addTodo(String username, String description, LocalDate targetDate, boolean done){
        Todo todo = new Todo(++todosCount, username, description, targetDate, done);
        todos.add(todo);
    }

    // given a username. You would find all his to-dos and return back them
    public List<Todo> findByUsername(String username){
            Predicate<? super Todo> predicate = todo -> todo.getusername().equalsIgnoreCase(username);
            return todos.stream().filter(predicate).toList();
    } 

    public void deleteById(int id){
        // todo.getId() == id
        // todo -> todo.getId() == id
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(@Valid Todo todo){
        deleteById(todo.getId());
        todos.add(todo);
    }
    

}


// First we need a todo controller to list all the todos in the page.
// So. we use listTodos.jsp