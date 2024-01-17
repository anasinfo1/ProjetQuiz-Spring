package com.quiz.quiz.controllers;

import com.quiz.quiz.models.Option;
import com.quiz.quiz.repositories.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/options")
public class OptionController {

    @Autowired
    private OptionRepository optionRepository;

    @GetMapping
    public List<Option> getAllOptions() {
        return optionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Option> getOptionById(@PathVariable String id) {
        return optionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Option> createOption(@RequestBody Option option) {
        Option createdOption = optionRepository.save(option);
        return ResponseEntity.ok(createdOption);
    }

    // Add more endpoints as needed
}
