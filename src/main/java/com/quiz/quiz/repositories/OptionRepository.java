package com.quiz.quiz.repositories;

import com.quiz.quiz.models.Option;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OptionRepository extends MongoRepository<Option, String> {
    // Add custom query methods if needed
}
