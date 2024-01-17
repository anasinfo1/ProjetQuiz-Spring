package com.quiz.quiz.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Question {

    @Id
    private String id;
    private String text;

    @DBRef
    private List<Option> options;


    // Constructors, getters, and setters

    public Question() {
    }

    public Question(String text, List<Option> options) {
        this.text = text;
        this.options = options;
    }

    // Other constructors, getters, and setters as needed

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", options=" + options +
                '}';
    }

}
