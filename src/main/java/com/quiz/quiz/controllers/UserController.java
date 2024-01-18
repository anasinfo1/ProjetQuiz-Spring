package com.quiz.quiz.controllers;

import com.quiz.quiz.models.User;
import com.quiz.quiz.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    // http://localhost:3000/users
    @GetMapping()
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    // http://localhost:3000/users/:id
    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable String id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
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
            // Include the token in the response
            return ResponseEntity.ok(new AuthResponse(true, user));
        } else {
            // Invalid credentials
            return ResponseEntity.status(401).body(new AuthResponse(false,  null));
        }
    }



    // Additional class to represent the response structure
    private static class AuthResponse {
        private final boolean success;
        private final User user;

        public AuthResponse(boolean success, User user) {
            this.success = success;
            this.user = user;
        }

        public boolean isSuccess() {
            return success;
        }

        public User getUser() {
            return user;
        }

    }



}
