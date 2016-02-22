package com.librarian.entity;

import java.time.LocalDate;

public class Book {

    private String title;

    private String author;

    private LocalDate yearPublish;

    private boolean isCheckout=false;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getYearPublish() {
        return yearPublish;
    }

    public void setYearPublish(LocalDate yearPublish) {
        this.yearPublish = yearPublish;
    }

    @Override
    public String toString() {
        return
                "title='" + title + '\t' +
                        ", author='" + author + '\t' +
                        ", yearPublish='" + yearPublish +
                        '\n';

    }

    public void setCheckout(boolean checkout) {
        isCheckout = checkout;
    }

    public boolean isCheckout() {
        return isCheckout;
    }
}
