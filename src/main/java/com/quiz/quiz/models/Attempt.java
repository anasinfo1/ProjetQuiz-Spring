package com.quiz.quiz.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import javax.persistence.*;
import java.util.List;

@Document
public class Attempt {

    @Id
    private String id;

    private String studentId;
    private String quizId;
    private List<Answer> answers;

    // Constructors, getters, and setters


    public Attempt(String studentId, String quizId, List<Answer> answers) {
        this.studentId = studentId;
        this.quizId = quizId;
        this.answers = answers;
    }

    public Attempt() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
