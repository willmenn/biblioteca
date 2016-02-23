package com.librarian.dao.impl;

import com.librarian.dao.BooksDAO;
import com.librarian.entity.Book;
import com.librarian.exception.CheckinErrorRuntimeExcetion;
import com.librarian.exception.CheckoutErrorRuntimeException;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BooksDAOImpl implements BooksDAO {

    private List<Book> books;

    public BooksDAOImpl() {
        books = buildBookList();
    }

    public List<Book> getAllBooksInTheLibrary() {
        List<Book> avaliableBooks = new ArrayList<Book>();
        for (Book book :
                books) {
            if (book.isInTheLibrary()) {
                avaliableBooks.add(book);
            }
        }
        return avaliableBooks;
    }

    public Boolean insertBook(Book book) {
        return books.add(book);
    }

    public String checkoutBookByTitle(String title) {
        boolean checkoutSuccessful = false;
        for (Book book : books) {
            if ((book.getTitle().equals(title)) && (book.isInTheLibrary())) {
                book.checkOut();
                checkoutSuccessful = true;
            }
        }
        if (!checkoutSuccessful) {
            throw new CheckoutErrorRuntimeException(BOOK_NOT_AVAILABLE_MESSAGE);
        }
        return BOOK_IS_AVAILABLE_MESSAGE;
    }

    public String checkInBook(String title) {
        boolean checkinSuccesFull = false;
        for (Book bookStored :
                books) {
            if (bookStored.getTitle().equals(title)) {
                bookStored.checkIn();
                checkinSuccesFull = true;
            }
        }
        if (!checkinSuccesFull) {
            throw new CheckinErrorRuntimeExcetion(CHECKIN_FAIL_MESSAGE);
        }

        return CHECKIN_SUCCESSFUL_MESSAGE;
    }


    private List<Book> buildBookList() {
        books = new ArrayList<Book>();
        books.add(new Book("Harry Potter", "J.K Rolling", LocalDate.of(1992, Month.APRIL, 20)));
        books.add(new Book("Senhor dos Aneis", "Tolkien", LocalDate.of(1910, Month.AUGUST, 12)));
        return books;

    }
}
