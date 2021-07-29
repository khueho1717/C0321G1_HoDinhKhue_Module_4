package com.example.blogmanager.controller;


import com.example.blogmanager.model.entity.Blog;
import com.example.blogmanager.model.entity.Category;
import com.example.blogmanager.model.service.BlogService;
import com.example.blogmanager.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private BlogService blogService;

    @GetMapping("/categories")
    public ResponseEntity<Iterable<Category>> listCategories() {
        List<Category> categories = (List<Category>) categoryService.findAll();
//        ModelAndView modelAndView = new ModelAndView("/category/list");
//        modelAndView.addObject("categories", categories);
//        return modelAndView;
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @GetMapping("/create-category")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/create-category")
    public ModelAndView saveCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);

        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        modelAndView.addObject("message", "New category created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-category/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/category/edit");
            modelAndView.addObject("category", category.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-category")
    public ModelAndView updateCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "Category updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-category/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/category/delete");
            modelAndView.addObject("category", category.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-province")
    public String deleteCategory(@ModelAttribute("category") Category category) {
        categoryService.remove(category.getId());
        return "redirect:categories";
    }

//    @GetMapping("/view-category/{id}")
//    public ModelAndView viewCategory(@PathVariable("id") Long id) {
//        Optional<Category> category = categoryService.findById(id);
//        Iterable<Blog> blogs = blogService.findAllByCategoryId(id);
//        ModelAndView modelAndView = new ModelAndView("/category/view");
//        modelAndView.addObject("category", category.get());
//        modelAndView.addObject("blogs", blogs);
//        return modelAndView;
//    }

    @GetMapping("/view-category/{id}")
    public ResponseEntity<Iterable<Blog>> viewCategory(@PathVariable("id") Long id) {
        List<Blog> blogs = (List<Blog>) blogService.findAllByCategoryId(id);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
}
