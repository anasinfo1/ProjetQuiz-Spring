package com.quiz.quiz.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Quiz {
    @Id
    private String id;
    private String title;
    private String professorId;
    @DBRef
    private List<Question> questions;


    // Constructors, getters, and setters
    public Quiz() {
        // Default constructor required by Spring Data MongoDB
    }

    public Quiz(String title, String professorId, List<Question> questions) {
        this.title = title;
        this.professorId = professorId;
        this.questions = questions;
    }

    // Getters and setters...

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", professorId='" + professorId + '\'' +
                ", questions=" + questions +
                '}';
    }
}
