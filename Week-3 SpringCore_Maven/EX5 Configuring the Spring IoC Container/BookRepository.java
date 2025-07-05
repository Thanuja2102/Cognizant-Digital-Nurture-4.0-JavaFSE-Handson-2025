package com.library.repository;

import com.library.model.Book;
import java.util.List;

public interface BookRepository {
    List<Book> findAll();
}



