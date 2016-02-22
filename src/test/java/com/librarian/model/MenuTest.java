package com.librarian.model;

import com.librarian.dao.impl.BooksDAOImpl;
import com.librarian.entity.Book;
import com.librarian.entity.builder.BookBuilder;
import com.librarian.util.ScannerLibrayMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {

    private Menu menu;

    @Before
    public void setUp() {
        menu = new Menu();
    }

    @Test
    public void shouldReturnMenuOptions() {
        String options = menu.getOptions();
        String expected = Menu.LIST_ALL_BOOKS_OPTIOIN + Menu.LIST_ALL_BOOKS_DESCRIPTION + "\n"
                + Menu.CHECKOUT_OPTION + Menu.CHECKOUT_BOOK_MESSAGE + "\n"
                + Menu.RETURN_BOOK_OPTION + Menu.RETURN_BOOK_MESSAGE + "\n"
                + Menu.QUIT_SYSTEM_OPTION + Menu.QUIT_SYSTEM_DESCRIPTION + "\n";
        assertEquals(expected, options);
    }

    @Test
    public void shouldReturnAllBooks() {
        String allbooks = menu.processInput(Menu.LIST_ALL_BOOKS_OPTIOIN);
        assertFalse(allbooks.isEmpty());
    }

    @Test
    public void shouldReturnEmpty() {
        String empty = menu.processInput(Menu.QUIT_SYSTEM_OPTION);
        assertTrue(empty.isEmpty());
    }

    @Test
    public void shouldCheckoutBook() {
        String title = "Funcacao";
        ScannerLibrayMock scannerMock = new ScannerLibrayMock();
        scannerMock.setResponseFromScanner(title);
        menu.setScannerLibrary(scannerMock);
        Book book = new BookBuilder().withTitle(title).build();
        menu.getDao().insertBook(book);
        String checkoutStatusMessage = menu.processInput(Menu.CHECKOUT_OPTION);
        assertEquals(BooksDAOImpl.BOOK_IS_AVAILABLE_MESSAGE, checkoutStatusMessage);
    }

    @Test
    public void shouldThrowInvalidOptionArg() {
        try {
            menu.processInput("100");
            fail("Must send");
        } catch (RuntimeException exception) {
            assertEquals(Menu.INVALID_OPTION_MESSAGE, exception.getMessage());
        }
    }

}
