package com.spring.microservices.registration.controller;

import com.spring.microservices.registration.model.User;
import com.spring.microservices.registration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserRepository repository;

    //  http://localhost:8080/users/user/1
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUsersById(@PathVariable Long id) {
        User user = repository.findById(id);
        return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);
    }

    //  http://localhost:8080/users/user/all
    @GetMapping("/user/all")
    public Collection<User> findAll() {
        return repository.findAll();
    }

    //  http://localhost:8080/users/user
    //  { "firstName": "firstName", "lastName": "lastName", "email": "email", "password": "password" }
    @PostMapping("/user")
    public ResponseEntity<@Valid User> addUser(@Valid @RequestBody User user) {
        user = repository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //  http://localhost:8080/users/user/1
    //  { "id": 1, "firstName": "firstName", "lastName": "lastName", "email": "email", "password": "password" }
    @PutMapping("/user/{id}")
    ResponseEntity<@Valid User> editUser(@Valid @RequestBody User user) {
        user = repository.save(user);
        return ResponseEntity.accepted().body(user);
    }

    //  http://localhost:8080/users/user/1
    @DeleteMapping("/user/{id}")
    ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}