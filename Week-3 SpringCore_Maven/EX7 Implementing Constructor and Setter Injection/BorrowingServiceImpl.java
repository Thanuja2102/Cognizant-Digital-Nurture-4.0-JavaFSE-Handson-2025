package com.library.service;

import com.library.model.Book;
import com.library.repository.BookRepository;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BorrowingServiceImpl {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void borrowBookById(int bookId) {
        Book book = bookRepository.findById(bookId);
        if (book != null) {
            if (book.isAvailable()) {
                book.setAvailable(false);
                book.setBorrowedDate(LocalDate.now());
                bookRepository.update(book);
                System.out.println("Borrowed: " + book.getTitle());
            } else {
                System.out.println("Book already borrowed: " + book.getTitle());
            }
        } else {
            System.out.println("Book with ID " + bookId + " not found.");
        }
    }

    public void returnBookWithFine(int bookId) {
        Book book = bookRepository.findById(bookId);
        if (book != null && !book.isAvailable()) {
            long daysBorrowed = ChronoUnit.DAYS.between(book.getBorrowedDate(), LocalDate.now());
            double fine = daysBorrowed > 7 ? (daysBorrowed - 7) * 2.0 : 0.0;
            book.setAvailable(true);
            book.setBorrowedDate(null);
            bookRepository.update(book);
            System.out.println("Returned: " + book.getTitle() + ", Fine: ₹" + fine);
        } else {
            System.out.println("Book is either not borrowed or doesn't exist.");
        }
    }

    public void displayBorrowedBooks() {
        bookRepository.findBorrowedBooks()
                .forEach(book -> System.out.println("Borrowed: " + book.getTitle() + " on " + book.getBorrowedDate()));
    }
}
