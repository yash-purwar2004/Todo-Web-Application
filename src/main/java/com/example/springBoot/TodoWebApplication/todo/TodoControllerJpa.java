package com.example.springBoot.TodoWebApplication.todo;
import java.time.LocalDate;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
// This annotation marks the class as a web controller, meaning that it is ready to handle web requests. 
// The @Controller annotation is a specialization of the @Component annotation, allowing for auto-detection through classpath scanning.
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@SessionAttributes("username")
public class TodoControllerJpa {
    public TodoControllerJpa(TodoRepository todoRepository){
        super();
        this.todoRepository = todoRepository;
    }

    private TodoRepository todoRepository;




    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        String username = (String)model.get("username");
        List<Todo> todos = todoRepository.findByUsername(username);
        model.addAttribute("todos", todos);
        return "listTodos";
    }


    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model) {
        String username = (String)model.get("username");
        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }


    // When we add values in description. We add values with POST request
    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    // We are adding a additional attribute for displaying validation errors
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()){
            return "todo";
        }

        String username = (String)model.get("username");
        todo.setusername(username);
        todoRepository.save(todo);
        // todoService.addTodo(username, todo.getdescription(), todo.gettargetDate(), false);
        return "redirect:list-todos";
    }


    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }


    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        Todo todo = todoRepository.findById(id).get();
        model.addAttribute("todo", todo);
        return "todo";
    }


    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()){
            return "todo";
        }

        String username = (String)model.get("username");
        todo.setusername(username);
        todoRepository.save(todo);
        return "redirect:list-todos";
    }
    
    
}
