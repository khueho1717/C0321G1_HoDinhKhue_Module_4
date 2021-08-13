package com.example.manager_movie.controller;

import com.example.manager_movie.dto.MovieDto;
import com.example.manager_movie.model.entity.Movies;
import com.example.manager_movie.model.service.IMoviesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/movies")
public class MovieControlller {

    @Autowired
    IMoviesService moviesService;

    @GetMapping
    public String listMovies(@PageableDefault(value = 4)Pageable pageable, Model model){
        Page<Movies> movies=moviesService.findAll( pageable);
        model.addAttribute("movies",movies);
        return "movie/list";
    }

    @GetMapping("/create-movie")
    public String showFormCreateMovie(Model model) {
        model.addAttribute("movie", new MovieDto());
        return "/movie/create";
    }

    @PostMapping("/create-movie")
    public String saveBlog(@Validated @ModelAttribute(name = "movie") MovieDto movieDto, BindingResult bindingResult, Model model) {
       new MovieDto().validate(movieDto,bindingResult);
        if (!bindingResult.hasErrors()) {
            Movies movie=new Movies();
            BeanUtils.copyProperties(movieDto,movie);
            Iterable<Movies> movies=moviesService.findAll();
            for (Movies movies1: movies){
                if (movies1.getCodeMovie().equals(movie.getCodeMovie())){
                    model.addAttribute("movie", movieDto);
                    model.addAttribute("messageFails", "Movie create failure");
                    model.addAttribute("messageCode", "mã trùng");
                    return "/movie/create";
                }
            }
            moviesService.save(movie);
            model.addAttribute("movie", new MovieDto());
            model.addAttribute("message", "Movie create successfully");
            return "/movie/create";
        }else {
            model.addAttribute("movie", movieDto);
            model.addAttribute("messageFails", "Movie create failure");
            return "/movie/create";
        }
    }

    @GetMapping("/edit-movie/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Optional<Movies> movie = moviesService.findById(id);
        if (movie.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/movie/edit");
            modelAndView.addObject("movie", movie.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-movie")
    public String updateCustomer(@Validated @ModelAttribute(name = "movie") MovieDto movieDto, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            Movies movie=new Movies();
            BeanUtils.copyProperties(movieDto,movie);
            moviesService.save(movie);
            model.addAttribute("movie", new MovieDto());
            model.addAttribute("message", "Movie update successfully");
            return "/movie/edit";
        }else {
            model.addAttribute("movie", movieDto);
            model.addAttribute("messageFails", "Movie update failure");
            return "/movie/edit";
        }
    }

    @GetMapping("/delete-movie")
    public String showDeleteForm(@RequestParam int id) {
        moviesService.remove(id);
        return "redirect:/movies";
    }

    @GetMapping("/view-movie/{id}")
    public ModelAndView showMovie(@PathVariable int id) {
        Optional<Movies> movie = moviesService.findById(id);
        if (movie.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/movie/view");
            modelAndView.addObject("movie", movie.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error/error");
            return modelAndView;
        }
    }
}
