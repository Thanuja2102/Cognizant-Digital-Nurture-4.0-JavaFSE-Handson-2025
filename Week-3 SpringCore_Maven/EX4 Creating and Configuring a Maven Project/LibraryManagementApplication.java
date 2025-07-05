package com.library.main;

import com.library.service.LibraryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        LibraryService service = context.getBean("libraryService", LibraryService.class);

        service.listAvailableBooks();
        service.borrowBook(2, 10);
        service.showBorrowedBooksAndFine();
        service.listAvailableBooks();
    }
}

