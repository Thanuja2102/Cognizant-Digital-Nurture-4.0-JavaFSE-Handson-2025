package com.library.main;

import com.library.repository.BookRepositoryImpl;
import com.library.service.BookServiceImpl;
import com.library.service.BorrowingServiceImpl;

public class LibraryApp {
    public static void main(String[] args) {
        BookRepositoryImpl repo = new BookRepositoryImpl();

        BookServiceImpl bookService = new BookServiceImpl();
        BorrowingServiceImpl borrowService = new BorrowingServiceImpl();

        bookService.setBookRepository(repo);
        borrowService.setBookRepository(repo);

        System.out.println("All Books:");
        bookService.displayBooks();

        borrowService.borrowBookById(2);
        borrowService.borrowBookById(2);
        borrowService.borrowBookById(99);

        System.out.println("After Borrowing:");
        bookService.displayBooks();
    }
}

