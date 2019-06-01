package com.todo.rest.webservices.restfulwebservices.todo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoResource {

    @Autowired
    TodoDataService todoDataService;

    @GetMapping("/users/{username}/todos")
    List<Todo> getTodos(@PathVariable String username) {
        return todoDataService.getTodos(username);
    }

    @GetMapping("/users/{username}/todos/{id}")
    Todo getTodos(@PathVariable String username, @PathVariable int id) {
        return todoDataService.getTodoById(id).get();
    }

    @PutMapping("users/{username}/todos/{id}")
    ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo) {
         Todo updatedTodo = todoDataService.save(todo);
         return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }

    @PostMapping("users/{username}/todos")
    ResponseEntity<Todo> createTodo(@PathVariable String username, @RequestBody Todo todo) {
        todo.setUserName(username);
        Todo createdTodo = todoDataService.save(todo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("users/{username}/todos/{id}")
    ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable int id) {
        if (todoDataService.deleteTodo(username, id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
