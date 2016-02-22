package com.librarian.entity.builder;

import com.librarian.entity.Book;

import java.time.LocalDate;

public class BookBuilder {


    private Book myObject;


    public BookBuilder() {
        myObject = new Book();
    }

    public Book build() {
        return myObject;
    }

    public BookBuilder withTitle(String title) {
        myObject.setTitle(title);
        return this;
    }

    public BookBuilder withAuthor(String author) {
        myObject.setAuthor(author);
        return this;
    }

    public BookBuilder withYearPublished(LocalDate date) {
        myObject.setYearPublish(date);
        return this;
    }

    public BookBuilder checkoutBook() {
        myObject.setCheckout(true);
        return this;
    }
}
