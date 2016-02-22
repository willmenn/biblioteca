package com.librarian.dao.impl;

import com.librarian.dao.BooksDAO;
import com.librarian.entity.Book;
import com.librarian.entity.builder.BookBuilder;
import com.librarian.exception.CheckinErrorRuntimeExcetion;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class BooksDAOImplTest {

    private BooksDAO dao;

    @Before
    public void setUp() {
        dao = new BooksDAOImpl();
    }

    @Test
    public void shouldGetAListOfBooks() {
        List<Book> allBooks = dao.getAllBooks();
        assertNotNull(allBooks);
    }

    @Test
    public void shouldAddBookIntoDB() {
        Book book = new BookBuilder().withTitle("Suicide Red").withAuthor("J.K Rolling").build();
        Boolean isInseted = dao.insertBook(book);
        assertTrue(isInseted);
    }

    @Test
    public void shouldReturnAllBooksInMemory() {
        Book book = new BookBuilder().withAuthor("5 estralas").withTitle("Jessie").build();
        dao.insertBook(book);
        List<Book> allBooks = dao.getAllBooks();
        assertThat(allBooks, hasItems(book));
    }

    @Test
    public void shouldCheckoutBook() {
        Book book = insertTestBook();
        dao.checkoutBookByTitle("Test");
        List<Book> allBooks = dao.getAllBooks();
        assertThat(allBooks, not(hasItems(book)));
    }

    private Book insertTestBook() {
        Book book = new BookBuilder().withTitle("Test").build();
        dao.insertBook(book);
        return book;
    }


    @Test
    public void shouldCheckinBook() {
        Book book = insertTestBook();
        String checkInMessage = dao.checkInBook(book.getTitle());
        assertEquals(BooksDAO.CHECKIN_SUCCESSFUL_MESSAGE, checkInMessage);
    }

    @Test
    public void shouldThrowCheckinException() {
        try {
            dao.checkInBook("Issac Asimov");
            fail("Must throw CheckinErrorRuntimeException.");
        } catch (CheckinErrorRuntimeExcetion excetion) {
            assertEquals(BooksDAO.CHECKIN_FAIL_MESSAGE,excetion.getMessage());
        }
    }

}
