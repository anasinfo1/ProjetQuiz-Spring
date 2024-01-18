package com.quiz.quiz.repositories;

import com.quiz.quiz.models.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepository extends MongoRepository<Quiz.Question, String> {
    // You can add custom query methods here if needed
}
