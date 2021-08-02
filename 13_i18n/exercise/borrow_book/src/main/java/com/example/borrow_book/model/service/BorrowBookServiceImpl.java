package com.example.borrow_book.model.service;

import com.example.borrow_book.model.entity.Book;
import com.example.borrow_book.model.repository.BorrowBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowBookServiceImpl implements BorrowBookService {

    @Autowired
    BorrowBookRepository borrowBookRepository;

    @Override
    public List<Book> findAll() {
        return borrowBookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return borrowBookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        borrowBookRepository.save(book);
    }

}
