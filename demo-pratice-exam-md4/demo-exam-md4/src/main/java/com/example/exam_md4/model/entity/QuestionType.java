package com.example.exam_md4.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question_type")
public class QuestionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionTypeId;
    private String questionTypeName;
    @OneToMany(mappedBy = "questionType")
    private List<Question> questions;

    public QuestionType() {
    }

    public QuestionType(int questionTypeId, String questionTypeName, List<Question> questions) {
        this.questionTypeId = questionTypeId;
        this.questionTypeName = questionTypeName;
        this.questions = questions;
    }

    public int getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(int questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public String getQuestionTypeName() {
        return questionTypeName;
    }

    public void setQuestionTypeName(String questionTypeName) {
        this.questionTypeName = questionTypeName;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
