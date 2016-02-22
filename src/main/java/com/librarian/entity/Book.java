package com.librarian.entity;

import java.time.LocalDate;

public class Book {

    private String title;
    private String author;
    private LocalDate yearPublish;
    private boolean isInTheLibrary;

    public Book(String title, String author, LocalDate yearPublish) {
        this.title = title;
        this.author = author;
        this.yearPublish = yearPublish;
        this.isInTheLibrary = true;
    }



    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getYearPublish() {
        return yearPublish;
    }

    @Override
    public String toString() {
        return
                "title='" + title + '\t' +
                        ", author='" + author + '\t' +
                        ", yearPublish='" + yearPublish +
                        '\n';

    }

    public void checkOut() {
        this.isInTheLibrary = false;
    }

    public void checkIn() {
        this.isInTheLibrary = true;
    }

    public boolean isInTheLibrary() {
        return isInTheLibrary;
    }
}
