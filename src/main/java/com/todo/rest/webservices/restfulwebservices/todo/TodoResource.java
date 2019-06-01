package com.todo.rest.webservices.restfulwebservices.todo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("users/{username}/todos/{id}")
    ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable int id) {
        if (todoDataService.deleteTodo(username, id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
