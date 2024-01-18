package com.quiz.quiz.controllers;

import com.quiz.quiz.models.Quiz;
import com.quiz.quiz.repositories.QuestionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionRepository questionRepository;

    // Constructor injection of QuestionRepository
    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getQuestionById(@PathVariable String id) {
        Optional<Quiz.Question> questionOptional = questionRepository.findById(id);

        if (questionOptional.isPresent()) {
            return ResponseEntity.ok(questionOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Other methods for question-related operations can be added here

}
