package com.library.service;

import com.library.model.Book;
import com.library.repository.BookRepository;
import java.util.List;

public class BorrowingServiceImpl {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void borrowBookById(int bookId) {
        List<Book> books = bookRepository.findAll();
        for (Book book : books) {
            if (book.getId() == bookId) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Borrowed: " + book.getTitle());
                } else {
                    System.out.println("Book already borrowed: " + book.getTitle());
                }
                return;
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }
}

