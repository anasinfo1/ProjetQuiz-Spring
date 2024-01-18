package com.quiz.quiz.controllers;

import com.quiz.quiz.models.User;
import com.quiz.quiz.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @GetMapping("/")
    public List<User> getUsers(){
        return userRepository.findAll();
    }


    // http://localhost:3000/users/register
    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("success", true));
    }


    // http://localhost:3000/users/login
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User loginUser) {
        User user = userRepository.findByUsernameAndPassword(loginUser.getUsername(), loginUser.getPassword());

        if (user != null) {
            // Successfully logged in
            return ResponseEntity.ok(user);
        } else {
            // Invalid credentials
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }



}
