package com.example.blogmanager.model.service.serviceImpl;


import com.example.blogmanager.model.entity.Blog;
import com.example.blogmanager.model.repository.BlogRepository;
import com.example.blogmanager.model.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }


    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByTitleContaining(String title, Pageable pageable) {
        return blogRepository.findAllByTitleContaining(title,pageable);
    }

    @Override
    public Page<Blog> findAllByCategoryId(Long id, Pageable pageable) {
        return blogRepository.findAllByCategoryId(id, pageable);
    }

    @Override
    public Iterable<Blog> findAllByCategoryId(Long id) {
        return blogRepository.findAllByCategoryId(id);
    }

    @Override
    public Page<Blog> findTitleAndCateId(String search, Pageable pageable) {
        return blogRepository.findTitleAndCateId(search,pageable);
    }


}
