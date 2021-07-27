package com.example.borrow_book.model.service;

import com.example.borrow_book.model.entity.Book;

import java.util.List;
import java.util.Optional;


public interface BorrowBookService {
    List<Book> findAll();

    Optional<Book> findById(Integer id);

    void save(Book book);

}
