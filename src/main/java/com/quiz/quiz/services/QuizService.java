package com.quiz.quiz.services;

import com.quiz.quiz.models.Quiz;
import com.quiz.quiz.repositories.OptionRepository;
import com.quiz.quiz.repositories.QuestionRepository;
import com.quiz.quiz.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class QuizService {
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository; // Add this
    private final OptionRepository optionRepository; // Add this

    @Autowired
    public QuizService(QuizRepository quizRepository, QuestionRepository questionRepository, OptionRepository optionRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
        this.optionRepository = optionRepository;
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Quiz getQuizById(String quizId) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(quizId);
        return optionalQuiz.orElse(null);
    }

    public Quiz createQuiz(Quiz quiz) {
        for (Quiz.Question question : quiz.getQuestions()) {
            // Save each question
            for (Quiz.Question.Option option : question.getOptions()) {
                // Save each option
                if (option.getId() == null) {
                    option.setId(UUID.randomUUID().toString()); // Generate ID if null
                }
                optionRepository.save(option);
            }

            if (question.getId() == null) {
                question.setId(UUID.randomUUID().toString()); // Generate ID if null
            }
            questionRepository.save(question);
        }

        // Save the quiz after questions and options have IDs
        return quizRepository.save(quiz);
    }

    // Other methods...
}
