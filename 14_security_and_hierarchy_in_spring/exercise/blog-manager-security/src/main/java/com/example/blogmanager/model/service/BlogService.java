package com.example.blogmanager.model.service;


import com.example.blogmanager.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService extends GeneralService<Blog> {
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
    Page<Blog> findAllByCategoryId(Long id, Pageable pageable);
    Iterable<Blog> findAllByCategoryId(Long id);

    Page<Blog> findTitleAndCateId(String search, Pageable pageable);

}