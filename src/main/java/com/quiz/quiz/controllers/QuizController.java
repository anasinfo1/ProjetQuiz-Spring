package com.quiz.quiz.controllers;


import com.quiz.quiz.models.Quiz;
import com.quiz.quiz.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizzes")
public class QuizController {

    private final QuizRepository quizRepository;

    @Autowired
    public QuizController(QuizRepository quizService) {
        this.quizRepository = quizService;
    }

    // http://localhost:8093/quizzes
    @GetMapping("/")
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    // http://localhost:8093/quizzes/:id
    @GetMapping("/{id}")
    public Quiz getQuizById(@PathVariable String id) {
        return quizRepository.findById(id).orElse(null);
    }

    // http://localhost:8093/quizzes/create
    @PostMapping("/create")
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizRepository.save(quiz);
    }


    // http://localhost:8093/quizzes/:id
    @PutMapping("/{id}")
    public Quiz updateQuiz(@PathVariable String id, @RequestBody Quiz updatedQuiz) {
        updatedQuiz.setId(id);
        return quizRepository.save(updatedQuiz);
    }


    // http://localhost:8093/quizzes/:id
    @DeleteMapping("/{id}")
    public void deleteQuiz(@PathVariable String id) {
        quizRepository.deleteById(id);
    }
}

