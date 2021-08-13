package com.example.exam_md4.controller;

import com.example.exam_md4.dto.QuestionDto;
import com.example.exam_md4.model.entity.Question;
import com.example.exam_md4.model.service.question_service.QuestionService;
import com.example.exam_md4.model.service.question_service.QuestionTypeService;
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
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @Autowired
    QuestionTypeService questionTypeService;


    @GetMapping
    public String listQuestion(@RequestParam(value = "search", required = false) String search, @PageableDefault(value = 4) Pageable pageable, Model model) {
       Page<Question> questions;
        if (search != null){
            questions=questionService.findQuestions(search, pageable);
            model.addAttribute("questions",questions);
            model.addAttribute("search",search);
            model.addAttribute("questionTypes",questionTypeService.findAll());
            return "/question/list";
        }else {
            questions = questionService.findAll(pageable);
            model.addAttribute("questions", questions);
            model.addAttribute("questionTypes",questionTypeService.findAll());
            return "/question/list";
        }
    }

    @GetMapping("/create-question")
    public String showFormCreateQuestion(Model model) {
        model.addAttribute("question", new QuestionDto());
        model.addAttribute("questionType", questionTypeService.findAll());
        return "/question/create";
    }

    @PostMapping("/create-question")
    public String saveBlog(@Validated @ModelAttribute(name = "question") QuestionDto questionDto, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            Question question=new Question();
            BeanUtils.copyProperties(questionDto,question);
            questionService.save(question);
            model.addAttribute("question", new QuestionDto());
            model.addAttribute("questionType", questionTypeService.findAll());
            model.addAttribute("message", "Question create successfully");
            return "/question/create";
        }else {
            model.addAttribute("question", questionDto);
            model.addAttribute("questionType", questionTypeService.findAll());
            model.addAttribute("messageFails", "Question create failure");
            return "/question/create";
        }
    }

    @GetMapping("/edit-question/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Optional<Question> question = questionService.findById(id);
        if (question.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/question/edit");
            modelAndView.addObject("questionType", questionTypeService.findAll());
            modelAndView.addObject("question", question.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-question")
    public String updateQuestion(@Validated @ModelAttribute(name = "question") QuestionDto questionDto, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            Question question=new Question();
            BeanUtils.copyProperties(questionDto,question);
            questionService.save(question);
            model.addAttribute("question", question);
            model.addAttribute("questionType", questionTypeService.findAll());
            model.addAttribute("message", "Question update successfully");
            return "/question/edit";
        }else {
            model.addAttribute("question", questionDto);
            model.addAttribute("questionType", questionTypeService.findAll());
            model.addAttribute("messageFails", "Question update failure");
            return "/question/edit";
        }
    }

    @GetMapping("/delete-question")
    public String showDeleteForm(@RequestParam int id) {
        questionService.remove(id);
        return "redirect:/questions";
    }
}
