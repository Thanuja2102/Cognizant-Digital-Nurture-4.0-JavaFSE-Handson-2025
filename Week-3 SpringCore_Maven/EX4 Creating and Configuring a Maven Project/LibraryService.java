package com.library.service;

public interface LibraryService {
    void listAvailableBooks();
    void borrowBook(int id, int days);
    void showBorrowedBooksAndFine();
}

