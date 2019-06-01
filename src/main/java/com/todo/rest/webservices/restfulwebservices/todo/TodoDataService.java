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
    private static long idCounter = 0;

    static {
        todos.add(new Todo(++idCounter,"sa", "Do Skydiving", new Date(), false));
        todos.add(new Todo(++idCounter,"Jon", "Become an expert in Angular", new Date(), false));
        todos.add(new Todo(++idCounter,"sa", "Lean Microservices architecture", new Date(), false));
    }

    public List<Todo> getTodos(String username) {
        return todos.stream().filter(todo -> todo.getUserName().equals(username)).collect(Collectors.toList());
    }

    public Todo save(Todo todo){
        if(todo.getId() > 0){
            deleteTodo(todo.getUserName(), todo.getId());
            todos.add(todo);
        }else{
            todo.setId(++idCounter);
            todos.add(todo);
        }
        return todo;
    }

    public boolean deleteTodo(String username, long id) {
        Optional<Todo> todo = getTodoById(id);

       if(todo.isPresent() && todo.get().getUserName().equals(username)){
           todos.remove(todo.get());
           return true;
       }
       return false;
    }

    public Optional<Todo> getTodoById(long id) {
        return todos.stream().filter(todo -> todo.getId() == id).findFirst();
    }
}
