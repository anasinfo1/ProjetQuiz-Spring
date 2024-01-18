package com.quiz.quiz.repositories;

import com.quiz.quiz.models.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface QuizRepository extends MongoRepository<Quiz, String> {
}

