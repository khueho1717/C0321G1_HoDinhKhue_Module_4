package com.example.exam_md4.model.service.question_service;

import com.example.exam_md4.model.entity.QuestionType;

public interface IQuestionTypeService {
    Iterable<QuestionType> findAll();
}
