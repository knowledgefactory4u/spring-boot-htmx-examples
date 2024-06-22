package com.knf.dev.demo.controller;

import com.knf.dev.demo.entity.Todo;
import com.knf.dev.demo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoRepository todoRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/create")
    public String createTodoView() {
        return "create";
    }

    @PostMapping("/create")
    public String createTodo(Todo todo, Model model) {

        todoRepository.save(todo);
        List<Todo> list = todoRepository.findAll();
        model.addAttribute("todos", list);
        return "read";
    }

    @GetMapping("/read")
    public String listTodo(Model model) {

        List<Todo> list = todoRepository.findAll();
        model.addAttribute("todos", list);
        return "read";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id, Model model) {

        todoRepository.deleteById(id);
        List<Todo> list = todoRepository.findAll();
        model.addAttribute("todos", list);
        return "read";
    }

    @GetMapping("/update/{id}")
    public String updateTodoView(@PathVariable Long id, Model model) {

        Todo todo = todoRepository.findById(id).get();
        model.addAttribute("todo", todo);
        return "update";
    }

    @PutMapping("/update/{id}")
    public String updateTodo(@PathVariable Long id, Model model, Todo t) {

        Todo todo = todoRepository.findById(id).get();
        todo.setPlanet(t.getPlanet());
        todo.setEmail(t.getEmail());
        todo.setFirstName(t.getFirstName());
        todo.setLastName(t.getLastName());
        todoRepository.save(todo);

        List<Todo> list = todoRepository.findAll();
        model.addAttribute("todos", list);
        return "read";
    }
}