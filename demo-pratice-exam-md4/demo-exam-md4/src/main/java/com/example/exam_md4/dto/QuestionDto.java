package com.example.exam_md4.dto;

import com.example.exam_md4.model.entity.QuestionType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;


public class QuestionDto implements Validator {

    private int questionId;
    @NotBlank(message = "hãy nhập tiêu đề cho câu hỏi")
    private String questionTitle;
    @NotBlank(message = "yêu cầu nhập nội dung câu hỏi")
    private String questionContent;
    private String answer;
    private QuestionType questionType;
    private String dateCreate;
    private byte status;

    public QuestionDto() {
    }

    public QuestionDto(int questionId, String questionTitle, String questionContent, String answer, QuestionType questionType, String dateCreate, byte status) {
        this.questionId = questionId;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.answer = answer;
        this.questionType = questionType;
        this.dateCreate = dateCreate;
        this.status = status;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        QuestionDto questionDto=(QuestionDto) target;

        if (questionDto.questionType.getQuestionTypeId()==-1){
            errors.rejectValue("questionType.questionTypeId","","yêu cầu chọn thể loại câu hỏi");
        }
    }
}
