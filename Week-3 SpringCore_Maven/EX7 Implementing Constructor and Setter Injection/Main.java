package com.library.main;

import com.library.repository.BookRepositoryImpl;
import com.library.service.BookServiceImpl;
import com.library.service.BorrowingServiceImpl;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BookRepositoryImpl repo = new BookRepositoryImpl();

        BookServiceImpl bookService = new BookServiceImpl(repo); // constructor injection
        bookService.setBookRepository(repo); // setter injection

        BorrowingServiceImpl borrowService = new BorrowingServiceImpl();
        borrowService.setBookRepository(repo);

        System.out.println("All Books:");
        bookService.displayBooks();

        System.out.println("\nBorrow operations:");
        borrowService.borrowBookById(2);
        borrowService.borrowBookById(3);

        System.out.println("\nBorrowed Books:");
        borrowService.displayBorrowedBooks();

        System.out.println("\nReturning Book:");
        borrowService.returnBookWithFine(2);

        System.out.println("\nAvailable Books:");
        bookService.printAvailableBooks();
    }
}
