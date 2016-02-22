package com.librarian.dao;

import com.librarian.entity.Book;

import java.util.List;

public interface BooksDAO {


    String BOOK_NOT_AVAILABLE_MESSAGE = "That book is not avaliable.";
    String BOOK_IS_AVAILABLE_MESSAGE = "Thank you! Enjoy the book";
    String CHECKIN_SUCCESSFUL_MESSAGE= "Thank you for returning the book.";
    String CHECKIN_FAIL_MESSAGE="That is not a valid book to return.";

    List<Book> getAllBooks();

    Boolean insertBook(Book book);

    String checkoutBookByTitle(String title);

    String checkInBook(String title);
}
