// AttemptService.java

package com.quiz.quiz.services;
import com.quiz.quiz.models.Attempt;
import com.quiz.quiz.repositories.AttemptRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AttemptService {

    private final AttemptRepository attemptRepository;

    @Autowired
    public AttemptService(AttemptRepository attemptRepository) {
        this.attemptRepository = attemptRepository;
    }

    public Attempt saveAttempt(Attempt attempt) {
        return attemptRepository.save(attempt);
    }

    public List<Attempt> getAttemptsByQuizId(String quizId) {
        return attemptRepository.findByQuizId(quizId);
    }
}



