package com.library.model;

import java.time.LocalDate;

public class Book {
    private int id;
    private String title;
    private String author;
    private boolean available;
    private LocalDate borrowedDate;

    public Book(int id, String title, String author, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = available;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public LocalDate getBorrowedDate() { return borrowedDate; }
    public void setBorrowedDate(LocalDate borrowedDate) { this.borrowedDate = borrowedDate; }

    @Override
    public String toString() {
        return id + ": " + title + " by " + author + (available ? " (Available)" : " (Not Available)");
    }
}