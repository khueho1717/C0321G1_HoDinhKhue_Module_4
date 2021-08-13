package com.example.exam_md4.model.repository;

import com.example.exam_md4.model.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends PagingAndSortingRepository<Question, Integer> {

    @Query(value = "select *" +
            "from question " +
            "join question_type on question.question_type_id = question_type.question_type_id " +
            "where question.question_title like '%h%' or question_type.question_type_name like '%h%'  " +
            "or question_type.question_type_id like '%h%'", nativeQuery = true)
    Page<Question> findQuestions(@Param("search") String search, Pageable pageable);

}
