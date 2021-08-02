package com.example.borrow_book.model.repository;

import com.example.borrow_book.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowBookRepository extends JpaRepository<Book,Integer> {
}
