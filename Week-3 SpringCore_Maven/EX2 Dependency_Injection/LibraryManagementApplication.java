package com.library.main;

import com.library.service.BookService;
import com.library.service.BorrowingService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = context.getBean("bookService", BookService.class);
        BorrowingService borrowingService = context.getBean("borrowingService", BorrowingService.class);

        bookService.printAvailableBooks();
        borrowingService.borrowBookById(2);
        borrowingService.borrowBookById(2);
        borrowingService.borrowBookById(99);
        bookService.printAvailableBooks();
    }
}