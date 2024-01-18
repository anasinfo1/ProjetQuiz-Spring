package com.quiz.quiz.repositories;

import com.quiz.quiz.models.Attempt;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AttemptRepository extends MongoRepository<Attempt, String> {
    // You can add custom query methods if needed
    List<Attempt> findByQuizId(String quizId);
}

