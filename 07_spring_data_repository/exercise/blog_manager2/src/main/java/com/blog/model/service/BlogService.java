package com.blog.model.service;

import com.blog.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService extends GeneralService<Blog> {
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByTitleContaining(String title,Pageable pageable);
    Page<Blog> findAllByCategoryId(Long id, Pageable pageable);
}