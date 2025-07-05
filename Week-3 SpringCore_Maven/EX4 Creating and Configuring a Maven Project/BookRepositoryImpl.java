package com.library.repository;

import com.library.model.Book;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    private List<Book> books = new ArrayList<>();

    public BookRepositoryImpl() {
        books.add(new Book(1, "Spring in Action"));
        books.add(new Book(2, "Effective Java"));
        books.add(new Book(3, "Clean Code"));
    }

    @Override
    public List<Book> findAll() {
        return books;
    }
}
