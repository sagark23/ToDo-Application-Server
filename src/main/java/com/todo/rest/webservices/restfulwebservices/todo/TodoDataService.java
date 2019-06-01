package com.todo.rest.webservices.restfulwebservices.todo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoDataService {

    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo("sa", "Do Skydiving", new Date(2019, 06, 1), false));
        todos.add(new Todo("Jon", "Become an expert in Angular", new Date(2019, 06, 1), false));
        todos.add(new Todo("sa", "Lean Microservices architecture", new Date(2019, 06, 1), false));
    }

    public List<Todo> getTodos(String username) {
        return todos.stream().filter(todo -> todo.getUserName().equals(username)).collect(Collectors.toList());
    }

    public boolean deleteTodo(String username, int id) {
        Optional<Todo> todo = getTodoById(id);

       if(todo.isPresent() && todo.get().getUserName().equals(username)){
           todos.remove(todo.get());
           return true;
       }
       return false;
    }

    private Optional<Todo> getTodoById(int id) {
        return todos.stream().filter(todo -> todo.getId() == id).findFirst();
    }
}
