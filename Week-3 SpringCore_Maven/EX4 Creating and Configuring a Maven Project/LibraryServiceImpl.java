package com.library.service;

import com.library.model.Book;
import com.library.repository.BookRepository;

public class LibraryServiceImpl implements LibraryService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void listAvailableBooks() {
        for (Book book : bookRepository.findAll()) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }

    @Override
    public void borrowBook(int id, int days) {
        for (Book book : bookRepository.findAll()) {
            if (book.getId() == id) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    book.setDaysBorrowed(days);
                    System.out.println("You borrowed: " + book.getTitle());
                } else {
                    System.out.println("Already borrowed.");
                }
                return;
            }
        }
        System.out.println("Book ID not found.");
    }

    @Override
    public void showBorrowedBooksAndFine() {
        for (Book book : bookRepository.findAll()) {
            if (!book.isAvailable()) {
                int fine = Math.max(0, book.getDaysBorrowed() - 7) * 5;
                System.out.println(book + " | Fine: ₹" + fine);
            }
        }
    }
}
