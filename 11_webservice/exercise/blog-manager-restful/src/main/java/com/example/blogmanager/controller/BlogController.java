package com.example.blogmanager.controller;


import com.example.blogmanager.model.entity.Blog;
import com.example.blogmanager.model.entity.Category;
import com.example.blogmanager.model.service.BlogService;
import com.example.blogmanager.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private ICategoryService categoryService;


    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("categories", categoryService.findAll());
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView saveBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("categories", categoryService.findAll());
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;
    }

    @GetMapping("/blogs")
    public ModelAndView listBlogs(@RequestParam(value = "search",required = false) String search,
                                  @PageableDefault(value = 3) Pageable pageable) {
        Page<Blog> blogs;
        if(search!=null){
//            blogs=blogService.findAllByTitleContaining(search,pageable);
            blogs=blogService.findTitleAndCateId(search,pageable);
            ModelAndView modelAndView =new ModelAndView();
            modelAndView.addObject("search",search);

        }else {
            blogs = blogService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("search",search);
        modelAndView.addObject("categories",categoryService.findAll());
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }



    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        if (blog.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("categories", categoryService.findAll());
            modelAndView.addObject("blog", blog.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("categories", categoryService.findAll());
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Blog updated successfully");
        return modelAndView;
    }

        @GetMapping("/view-blog/{id}")
    public ModelAndView showBlog(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        if (blog.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/blog/view");
            modelAndView.addObject("blog", blog.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }


    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        if (blog.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/blog/delete");
            modelAndView.addObject("blog", blog.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-blog")
    public String deleteBlog(@ModelAttribute("blog") Blog blog) {
        blogService.remove(blog.getId());
        return "redirect:blogs";
    }

}
