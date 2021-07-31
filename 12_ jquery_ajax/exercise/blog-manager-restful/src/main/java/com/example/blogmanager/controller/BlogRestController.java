package com.example.blogmanager.controller;

import com.example.blogmanager.model.entity.Blog;
import com.example.blogmanager.model.service.BlogService;
import com.example.blogmanager.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class BlogRestController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs")
    public ResponseEntity<Page<Blog>> listBlogs(@PageableDefault(value = 3) Pageable pageable) {
        Page<Blog> blogs =  blogService.findAll(pageable);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/search/{search}")
    public ResponseEntity<Page<Blog>> searchBlogsByTitle(@PathVariable String search,@PageableDefault(value = 3) Pageable pageable){
        Page<Blog> blogs =  blogService.findAllByTitleContaining(search,pageable);
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
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
