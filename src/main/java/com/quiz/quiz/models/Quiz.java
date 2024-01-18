package com.quiz.quiz.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document
public class Quiz {
    @Id
    private String id;
    private String title;
    private String professorId;

    @DBRef
    private List<Question> questions;

    // Constructors, getters, and setters...

    public Quiz() {
    }

    public Quiz(String title, String professorId, List<Question> questions) {
        this.title = title;
        this.professorId = professorId;
        this.questions = questions;
    }

    // Other constructors, getters, and setters as needed

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

    @Document
    public static class Question {
        @Id
        private String id;
        private String text;

        @DBRef
        private List<Option> options;

        // Constructors, getters, and setters...

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
            return "QuizQuestion{" +
                    "id='" + id + '\'' +
                    ", text='" + text + '\'' +
                    ", options=" + options +
                    '}';
        }

        @Document
        public static class Option {
            @Id
            private String id;
            private String text;
            @Field("isCorrect")
            private boolean isCorrect;

            // Constructors, getters, and setters...

            public Option() {
            }

            public Option(String text, boolean isCorrect) {
                this.text = text;
                this.isCorrect = isCorrect;
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

            public boolean isCorrect() {
                return isCorrect;
            }

            public void setCorrect(boolean isCorrect) {
                this.isCorrect = isCorrect;
            }

            @Override
            public String toString() {
                return "QuizOption{" +
                        "id='" + id + '\'' +
                        ", text='" + text + '\'' +
                        ", isCorrect=" + isCorrect +
                        '}';
            }
        }
    }
}
