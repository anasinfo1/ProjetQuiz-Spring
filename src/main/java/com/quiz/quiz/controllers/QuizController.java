package com.quiz.quiz.controllers;


import com.quiz.quiz.models.Quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import com.quiz.quiz.services.QuizService;


@RestController
@RequestMapping("/quizzes")
public class QuizController {
    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    // http://localhost:3000/quizzes/
    @GetMapping("/")
    public List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    // http://localhost:3000/quizzes/:id
    @GetMapping("/{quizId}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable String quizId) {
        Quiz quiz = quizService.getQuizById(quizId);
        if (quiz != null) {
            return ResponseEntity.ok(quiz);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // http://localhost:3000/quizzes/create
    @PostMapping("/create")
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizService.createQuiz(quiz);
    }

    // Add other controller methods as needed
}
