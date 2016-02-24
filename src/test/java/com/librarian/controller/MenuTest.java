package com.librarian.controller;

import com.librarian.dao.MoviesDAO;
import com.librarian.dao.impl.BooksDAOImpl;
import com.librarian.entity.Book;
import com.librarian.util.ScannerLibrayMock;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

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
        String expected = Menu.LIST_ALL_BOOKS_OPTION + Menu.LIST_ALL_BOOKS_DESCRIPTION + "\n"
                + Menu.CHECKOUT_BOOK_OPTION + Menu.CHECKOUT_BOOK_MESSAGE + "\n"
                + Menu.RETURN_BOOK_OPTION + Menu.RETURN_BOOK_MESSAGE + "\n"
                + Menu.LIST_ALL_MOVIES_OPTION + Menu.LIST_ALL_MOVIES_MESSAGE + "\n"
                + Menu.CHECKOUT_MOVIE_OPTION + Menu.CHECKOUT_MOVIE_MESSAGE + "\n"
                + Menu.CHECKIN_MOVIE_OPTION + Menu.CHECKIN_MOVIE_MESSAGE + "\n"
                + Menu.USER_DETAILS_OPTION + Menu.USER_DETAILS_MESSAGE+ "\n"
                + Menu.QUIT_SYSTEM_OPTION + Menu.QUIT_SYSTEM_DESCRIPTION + "\n";
        assertEquals(expected, options);
    }

    @Test
    public void shouldReturnAllBooks() {
        String allbooks = menu.processInput(Menu.LIST_ALL_BOOKS_OPTION);
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

        Book book = new Book(title, "", LocalDate.of(1991, Month.APRIL, 13));
        menu.getDao().insertBook(book);

        String checkoutStatusMessage = menu.processInput(Menu.CHECKOUT_BOOK_OPTION);
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

    @Test
    public void shouldListAllMovies(){
        String allMovies = menu.processInput(Menu.LIST_ALL_MOVIES_OPTION);
        assertNotNull(allMovies);
    }

    @Test
    public void shouldCheckoutMovie(){
        String title = "Harry Potter";
        ScannerLibrayMock scannerMock = new ScannerLibrayMock();
        scannerMock.setResponseFromScanner(title);
        menu.setScannerLibrary(scannerMock);
        String checkoutSuccessfulMessage = menu.processInput(Menu.CHECKOUT_MOVIE_OPTION);
        assertEquals(MoviesDAO.MOVIE_IS_AVAILABLE_MESSAGE,checkoutSuccessfulMessage);
    }

    @Test
    public void shouldNotChkoutMovie(){
        String title = "Indiana Jones";
        ScannerLibrayMock scannerMock = new ScannerLibrayMock();
        scannerMock.setResponseFromScanner(title);
        menu.setScannerLibrary(scannerMock);
        String checkoutunSuccessfulMessage = menu.processInput(Menu.CHECKOUT_MOVIE_OPTION);
        assertEquals(MoviesDAO.MOVIE_NOT_AVAILABLE_MESSAGE,checkoutunSuccessfulMessage);
    }

    @Test
    public void shouldCheckinMovie(){
        String title = "Harry Potter";
        ScannerLibrayMock scannerMock = new ScannerLibrayMock();
        scannerMock.setResponseFromScanner(title);
        menu.setScannerLibrary(scannerMock);

        String checkoutunSuccessfulMessage = menu.processInput(Menu.CHECKOUT_MOVIE_OPTION);
        assertEquals(MoviesDAO.MOVIE_IS_AVAILABLE_MESSAGE,checkoutunSuccessfulMessage);

        String successfulCheckin = menu.processInput(Menu.CHECKIN_MOVIE_OPTION);
        assertEquals(MoviesDAO.CHECKIN_SUCCESSFUL_MESSAGE,successfulCheckin);
    }

    @Test
    public void shouldNotCheckinMovie(){
        String title = "Indiana Jones";
        ScannerLibrayMock scannerMock = new ScannerLibrayMock();
        scannerMock.setResponseFromScanner(title);
        menu.setScannerLibrary(scannerMock);
        String unsuccessfulCheckin = menu.processInput(Menu.CHECKIN_MOVIE_OPTION);
        assertEquals(MoviesDAO.CHECKIN_FAIL_MESSAGE,unsuccessfulCheckin);
    }

}
