package com.example.exam_md4.model.service.question_service;

import com.example.exam_md4.model.entity.QuestionType;
import com.example.exam_md4.model.repository.QuestionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionTypeService implements IQuestionTypeService {

    @Autowired
    QuestionTypeRepository questionTypeRepository;

    @Override
    public Iterable<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }
}
