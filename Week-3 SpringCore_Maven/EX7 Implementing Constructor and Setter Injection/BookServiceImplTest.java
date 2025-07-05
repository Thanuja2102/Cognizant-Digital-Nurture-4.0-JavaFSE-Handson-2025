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
    public void setup() {
        bookRepository = mock(BookRepository.class);
        bookService = new BookServiceImpl(bookRepository);
    }

    @Test
    public void testDisplayBooks() {
        List<Book> books = Arrays.asList(
                new Book(1, "Effective Java", "Joshua Bloch", true),
                new Book(2, "Clean Code", "Robert C. Martin", false)
        );
        when(bookRepository.findAll()).thenReturn(books);
        bookService.displayBooks();
    }
}


