package com.example.exam_md4.model.service.question_service;

import com.example.exam_md4.model.entity.Question;
import com.example.exam_md4.model.service.GeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuestionService extends GeneralService<Question> {
    Page<Question> findAll(Pageable pageable);

    Page<Question> findQuestions( String search, Pageable pageable);

}
