package com.quiz.quiz.controllers;

import com.quiz.quiz.models.User;
import com.quiz.quiz.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }


    // http://localhost:8093/register
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        // Perform validation and other checks if needed
        userRepository.save(user); // Save the user to the database

        return ResponseEntity.ok("User registered successfully!");
    }


    // http://localhost:8093/login
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User loginUser) {
        User user = userRepository.findByUsernameAndPassword(loginUser.getUsername(), loginUser.getPassword());

        if (user != null) {
            // Successfully logged in
            return ResponseEntity.ok("Login successful!");
        } else {
            // Invalid credentials
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }


}
