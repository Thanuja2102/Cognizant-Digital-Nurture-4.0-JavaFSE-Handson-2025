package com.smartlib.service;

import com.smartlib.model.Book;
import java.util.*;

public class AdminService {
    private Map<Integer, Book> books = new HashMap<>();
    private int counter = 1;

    public void addBook(Book book) {
        book.setId(counter++);
        books.put(book.getId(), book);
        System.out.println("[INFO] Book '" + book.getTitle() + "' added successfully.");
    }

    public Book getBook(int id) {
        return books.get(id);
    }

    public List<Book> listBooks() {
        return new ArrayList<>(books.values());
    }
}

