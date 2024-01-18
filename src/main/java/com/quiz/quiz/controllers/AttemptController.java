package com.quiz.quiz.controllers;

import com.quiz.quiz.models.Attempt;
import com.quiz.quiz.services.AttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/attempts")
public class AttemptController {

    private final AttemptService attemptService;

    @Autowired
    public AttemptController(AttemptService attemptService) {
        this.attemptService = attemptService;
    }

    // http://localhost:3000/attempts/create
    @PostMapping("/create")
    public ResponseEntity<Attempt> createAttempt(@RequestBody Attempt attempt) {
        Attempt savedAttempt = attemptService.saveAttempt(attempt);
        return new ResponseEntity<>(savedAttempt, HttpStatus.CREATED);
    }

    // http://localhost:3000/attempts/quiz/:id
    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<Attempt>> getAttemptsByQuizId(@PathVariable String quizId) {
        List<Attempt> attempts = attemptService.getAttemptsByQuizId(quizId);
        return new ResponseEntity<>(attempts, HttpStatus.OK);
    }
}
