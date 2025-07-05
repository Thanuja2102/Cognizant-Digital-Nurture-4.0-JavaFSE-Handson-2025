package com.library.model;

public class Book {
    private int id;
    private String title;
    private boolean available = true;
    private int daysBorrowed = 0;

    public Book() {}
    public Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return available; }
    public int getDaysBorrowed() { return daysBorrowed; }

    public void setAvailable(boolean available) { this.available = available; }
    public void setDaysBorrowed(int daysBorrowed) { this.daysBorrowed = daysBorrowed; }

    @Override
    public String toString() {
        return "[" + id + "] " + title + (available ? " (Available)" : " (Borrowed for " + daysBorrowed + " days)");
    }
}

