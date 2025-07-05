package com.library.service;
import com.library.model.Book;
import com.library.repository.BookRepository;

public class BorrowingServiceImpl implements BorrowingService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void borrowBookById(int bookId) {
        for (Book book : bookRepository.findAll()) {
            if (book.getId() == bookId) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Borrowed: " + book.getTitle());
                } else {
                    System.out.println("Book is already borrowed: " + book.getTitle());
                }
                return;
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }
}