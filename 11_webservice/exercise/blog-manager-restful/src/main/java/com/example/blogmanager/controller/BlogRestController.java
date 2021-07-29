package com.example.blogmanager.controller;

import com.example.blogmanager.model.entity.Blog;
import com.example.blogmanager.model.service.BlogService;
import com.example.blogmanager.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BlogRestController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/blogs")
    public ResponseEntity<Iterable<Blog>> listBlogs() {
        List<Blog> blogs = (List<Blog>) blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/view-blog/{id}")
    public ResponseEntity<Blog> showBlog(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog.get(), HttpStatus.OK);
    }
}
