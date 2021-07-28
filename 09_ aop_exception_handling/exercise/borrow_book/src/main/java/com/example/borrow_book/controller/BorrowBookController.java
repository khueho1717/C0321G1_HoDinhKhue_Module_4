package com.example.borrow_book.controller;

import com.example.borrow_book.exception.BorrowBookException;
import com.example.borrow_book.model.entity.Book;
import com.example.borrow_book.model.service.BorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BorrowBookController {
    @Autowired
    BorrowBookService borrowBookService;

    @GetMapping("/list")
    public String showBook(Model model){
        List<Book> books=borrowBookService.findAll();
        model.addAttribute("books",books);
        return "/book/list";
    }

    @GetMapping("/detail-book/{id}")
    public String showBorrowBook(@PathVariable int id, Model model){
        Optional<Book> book=borrowBookService.findById(id);
        model.addAttribute("book",book.get());
        return "/book/detail";
    }

    @GetMapping("/borrow-book/{id}")
    public String borrowBook(@PathVariable int id,Model model) throws BorrowBookException {
        Optional<Book> book=borrowBookService.findById(id);
        book.get().setAmount(book.get().getAmount()-1);
        if (book.get().getAmount()<0){
            throw new BorrowBookException();
        }else {
            borrowBookService.save(book.get());
            model.addAttribute("books", borrowBookService.findAll());
            return "/book/list";
        }
    }

    @GetMapping("/roll-book/{id}")
    public String rollBook(@PathVariable int id,Model model){
        Optional<Book> book=borrowBookService.findById(id);
        if (book.get().getAmount()>=10){
            model.addAttribute("message","sach du so luong roi");
        }else {
            book.get().setAmount(book.get().getAmount() + 1);
            borrowBookService.save(book.get());
            model.addAttribute("books", borrowBookService.findAll());
        }
        return "/book/list";
    }
    @ExceptionHandler(BorrowBookException.class)
    public String showError(){
        return "/book/error";
    }
}
