package com.quiz.quiz.models;

import javax.persistence.*;


public class Answer {

    @Id
    private Long id;
    private String questionId;
    private Quiz.Question.Option selectedOption;

    // Constructors, getters, and setters

    public Answer(String questionId, Quiz.Question.Option selectedOption) {
        this.questionId = questionId;
        this.selectedOption = selectedOption;
    }

    public Answer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public Quiz.Question.Option getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(Quiz.Question.Option selectedOption) {
        this.selectedOption = selectedOption;
    }
}

