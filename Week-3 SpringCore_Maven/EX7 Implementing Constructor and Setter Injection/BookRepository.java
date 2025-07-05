package com.library.repository;

import com.library.model.Book;
import java.util.List;

public interface BookRepository {
    List<Book> findAll();
    Book findById(int id);
    void update(Book book);
    List<Book> findBorrowedBooks();
}