package com.library.service;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;


import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class BorrowingServiceImplTest {
    private BookRepository bookRepository;
    private BorrowingServiceImpl borrowingService;

    @Before
    public void setup() {
        bookRepository = mock(BookRepository.class);
        borrowingService = new BorrowingServiceImpl();
        borrowingService.setBookRepository(bookRepository);
    }

    @Test
    public void testBorrowAvailableBook() {
        Book book = new Book(1, "Effective Java", "Joshua Bloch", true);
        when(bookRepository.findById(1)).thenReturn(book);

        borrowingService.borrowBookById(1);

        assertFalse(book.isAvailable());
        assertNotNull(book.getBorrowedDate());
        verify(bookRepository).update(book);
    }

    @Test
    public void testReturnBookWithFine_NoFine() {
        Book book = new Book(3, "Clean Code", "Robert C. Martin", false);
        book.setBorrowedDate(LocalDate.now().minusDays(5));
        when(bookRepository.findById(3)).thenReturn(book);

        borrowingService.returnBookWithFine(3);

        assertTrue(book.isAvailable());
        assertNull(book.getBorrowedDate());
        verify(bookRepository).update(book);
    }
}

