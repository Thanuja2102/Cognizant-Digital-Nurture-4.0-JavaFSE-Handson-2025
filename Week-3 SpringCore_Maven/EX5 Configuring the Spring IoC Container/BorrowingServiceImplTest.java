package com.library.service;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class BorrowingServiceImplTest {
    private BookRepository mockRepository;
    private BorrowingServiceImpl borrowingService;

    @Before
    public void setUp() {
        mockRepository = mock(BookRepository.class);
        borrowingService = new BorrowingServiceImpl();
        borrowingService.setBookRepository(mockRepository);
    }

    @Test
    public void testBorrowAvailableBook() {
        Book book = new Book(1, "Clean Architecture", "Robert C. Martin", true);
        when(mockRepository.findAll()).thenReturn(Arrays.asList(book));
        borrowingService.borrowBookById(1);
        assertFalse(book.isAvailable());
    }

    @Test
    public void testBorrowAlreadyBorrowedBook() {
        Book book = new Book(2, "Clean Code", "Robert C. Martin", false);
        when(mockRepository.findAll()).thenReturn(Arrays.asList(book));
        borrowingService.borrowBookById(2);
        assertFalse(book.isAvailable());
    }

    @Test
    public void testBorrowNonExistentBook() {
        when(mockRepository.findAll()).thenReturn(Arrays.asList());
        borrowingService.borrowBookById(100);
    }
}
