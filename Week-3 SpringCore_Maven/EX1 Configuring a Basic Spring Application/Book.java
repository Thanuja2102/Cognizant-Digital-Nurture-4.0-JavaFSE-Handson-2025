package com.smartlib.model;

public class Book {
    private int id;
    private String title;
    private String author;
    private boolean issued;

    public Book() {}

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public boolean isIssued() { return issued; }
    public void setIssued(boolean issued) { this.issued = issued; }
}

