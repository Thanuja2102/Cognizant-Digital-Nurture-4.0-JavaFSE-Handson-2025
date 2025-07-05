package com.library.service;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;

public class BookServiceImplTest {
    private BookRepository mockRepository;
    private BookServiceImpl bookService;

    @Before
    public void setUp() {
        mockRepository = mock(BookRepository.class);
        bookService = new BookServiceImpl();
        bookService.setBookRepository(mockRepository);
    }

    @Test
    public void testDisplayBooks() {
        List<Book> mockBooks = Arrays.asList(
                new Book(1, "Effective Java", "Joshua Bloch", true),
                new Book(2, "Clean Code", "Robert C. Martin", true)
        );
        when(mockRepository.findAll()).thenReturn(mockBooks);
        bookService.displayBooks();
        verify(mockRepository, times(1)).findAll();
    }
}
