package com.library.service;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import static org.mockito.Mockito.*;
import com.library.service.BorrowingServiceImpl;

public class BorrowingServiceImplTest {
    private BorrowingServiceImpl borrowingService;
    private BookRepository bookRepository;

    @Before
    public void setUp() {
        bookRepository = mock(BookRepository.class);
        borrowingService = new BorrowingServiceImpl();
        borrowingService.setBookRepository(bookRepository);
    }

    @Test
    public void testBorrowAvailableBook() {
        Book book = new Book(1, "Domain-Driven Design", "Eric Evans");
        book.setAvailable(true);
        when(bookRepository.findAll()).thenReturn(Arrays.asList(book));
        borrowingService.borrowBookById(1);
    }

    @Test
    public void testBorrowAlreadyBorrowedBook() {
        Book book = new Book(2, "PoEAA", "Martin Fowler");
        book.setAvailable(false);
        when(bookRepository.findAll()).thenReturn(Arrays.asList(book));
        borrowingService.borrowBookById(2);
    }

    @Test
    public void testBorrowNonExistentBook() {
        when(bookRepository.findAll()).thenReturn(Arrays.asList());
        borrowingService.borrowBookById(999);
    }
}
