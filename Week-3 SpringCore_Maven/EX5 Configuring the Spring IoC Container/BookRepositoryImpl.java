package com.library.repository;

import com.library.model.Book;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    private final List<Book> books = new ArrayList<>();

    public BookRepositoryImpl() {
        books.add(new Book(1, "Effective Java", "Joshua Bloch", true));
        books.add(new Book(2, "Clean Code", "Robert C. Martin", true));
        books.add(new Book(3, "Refactoring", "Martin Fowler", false));
    }

    @Override
    public List<Book> findAll() {
        return books;
    }
}
