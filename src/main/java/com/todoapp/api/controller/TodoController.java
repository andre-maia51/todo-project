package com.todoapp.api.controller;

import com.todoapp.api.domain.todo.Todo;
import com.todoapp.api.domain.todo.TodoDTO;
import com.todoapp.api.domain.todo.TodoDetailedDTO;
import com.todoapp.api.domain.todo.TodoRepository;
import com.todoapp.api.infra.exceptions.TodoNotFoundException;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/todos")
@SecurityRequirement(name = "bearer-key")
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public ResponseEntity<Page<TodoDetailedDTO>> getActiveTodos(@PageableDefault(sort = {"title"}) Pageable pageable) {
        var page = todoRepository.findAllByActiveTrue(pageable).map(TodoDetailedDTO::new);
        return ResponseEntity.ok(page);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TodoDetailedDTO> postTodo(@RequestBody TodoDTO data, UriComponentsBuilder uriBuilder) {
        var todo = new Todo(data);
        todoRepository.save(todo);
        var uri = uriBuilder.path("todo/{id}").buildAndExpand(todo.getId()).toUri();
        return ResponseEntity.created(uri).body(new TodoDetailedDTO(todo));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TodoDetailedDTO> putTodo(@PathVariable Long id, @RequestBody TodoDTO data) {
        var todo = todoRepository.findById(id).orElseThrow(TodoNotFoundException::new);
        todo.updateTodoInfo(data);
        return ResponseEntity.ok(new TodoDetailedDTO(todo));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        var todo = todoRepository.findById(id).orElseThrow(TodoNotFoundException::new);
        todo.deleteTodo();
        return ResponseEntity.noContent().build();
    }
    
}
