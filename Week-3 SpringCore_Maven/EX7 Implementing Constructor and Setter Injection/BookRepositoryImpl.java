package com.library.repository;

import com.library.model.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public Book findById(int id) {
        return books.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void update(Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == book.getId()) {
                books.set(i, book);
                break;
            }
        }
    }

    @Override
    public List<Book> findBorrowedBooks() {
        return books.stream().filter(b -> !b.isAvailable()).collect(Collectors.toList());
    }
}
