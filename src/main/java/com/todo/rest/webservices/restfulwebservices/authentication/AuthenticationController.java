package com.todo.rest.webservices.restfulwebservices.authentication;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController {

    @GetMapping(path = "/basicAuth")
    public AuthenticationBean authenticate() {
        return new AuthenticationBean("Authenticated!");
    }

}
