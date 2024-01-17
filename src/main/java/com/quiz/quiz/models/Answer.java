package com.quiz.quiz.models;



import org.springframework.data.annotation.Id;

public class Answer {

    @Id
    private String id;

    private Question question;

    private Option selectedOption;

    // Constructors, getters, and setters

    public Answer() {
    }

    public Answer(Question question, Option selectedOption) {
        this.question = question;
        this.selectedOption = selectedOption;
    }

    // Other constructors, getters, and setters as needed

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Option getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(Option selectedOption) {
        this.selectedOption = selectedOption;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id='" + id + '\'' +
                ", question=" + question +
                ", selectedOption=" + selectedOption +
                '}';
    }
}
