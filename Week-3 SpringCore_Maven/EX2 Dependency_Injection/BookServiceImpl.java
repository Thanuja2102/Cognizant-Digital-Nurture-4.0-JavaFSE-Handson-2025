package com.library.service;

import com.library.model.Book;
import com.library.repository.BookRepository;
import java.util.List;

public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void printAvailableBooks() {
        List<Book> books = bookRepository.findAll();
        System.out.println("===== Available Books =====");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
