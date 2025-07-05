package com.library.service;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;

public class BookServiceImplTest {
    private BookRepository bookRepository;
    private BookServiceImpl bookService;

    @Before
    public void setUp() {
        bookRepository = mock(BookRepository.class);
        bookService = new BookServiceImpl();
        bookService.setBookRepository(bookRepository);
    }

    @Test
    public void testPrintAvailableBooks() {
        List<Book> mockBooks = Arrays.asList(
                new Book(1, "TDD", "Kent Beck"),
                new Book(2, "Refactoring", "Martin Fowler")
        );
        when(bookRepository.findAll()).thenReturn(mockBooks);
        bookService.printAvailableBooks();
        verify(bookRepository, times(1)).findAll();
    }
}
