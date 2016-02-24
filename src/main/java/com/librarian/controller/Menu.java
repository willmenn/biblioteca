package com.librarian.controller;

import com.librarian.dao.BooksDAO;
import com.librarian.dao.MoviesDAO;
import com.librarian.dao.impl.BooksDAOImpl;
import com.librarian.dao.impl.MoviesDAOImpl;
import com.librarian.entity.User;
import com.librarian.exception.InvalidOptionArgRuntimeException;
import com.librarian.util.ScannerLibrary;
import com.librarian.util.ScannerLibraryImpl;
import com.librarian.handler.InputHandler;


public class Menu {

    public static final String LIST_ALL_BOOKS_OPTION = "1";
    public static final String QUIT_SYSTEM_OPTION = "0";
    public static final String INVALID_OPTION_MESSAGE = "Invalid Option.Select a valid Option!";
    public static final String LIST_ALL_BOOKS_DESCRIPTION = " - List All Books";
    public static final String QUIT_SYSTEM_DESCRIPTION = " - Quit";
    public static final String CHECKOUT_BOOK_OPTION = "2";
    public static final String CHECKOUT_BOOK_MESSAGE = "- Checkout Book";
    public static final String RETURN_BOOK_OPTION = "3";
    public static final String MESSAGE_TO_ASK_FOR_THE_NAME = "Write the name:\n";
    public static final String RETURN_BOOK_MESSAGE = "- Return Book";
    public static final String LIST_ALL_MOVIES_OPTION = "4";
    public static final String LIST_ALL_MOVIES_MESSAGE = " - List All Movies";
    public static final String CHECKOUT_MOVIE_OPTION = "5";
    public static final String CHECKOUT_MOVIE_MESSAGE = " - Checkout Movie";
    public static final String CHECKIN_MOVIE_OPTION = "6";
    public static final String CHECKIN_MOVIE_MESSAGE = " - Checkin Movie";
    public static final String USER_DETAILS_OPTION = "7";
    public static final String USER_DETAILS_MESSAGE = " - User Details";

    private String[] options = new String[]{LIST_ALL_BOOKS_OPTION + LIST_ALL_BOOKS_DESCRIPTION,
            CHECKOUT_BOOK_OPTION + CHECKOUT_BOOK_MESSAGE,
            RETURN_BOOK_OPTION + RETURN_BOOK_MESSAGE,
            LIST_ALL_MOVIES_OPTION + LIST_ALL_MOVIES_MESSAGE,
            CHECKOUT_MOVIE_OPTION + CHECKOUT_MOVIE_MESSAGE,
            CHECKIN_MOVIE_OPTION + CHECKIN_MOVIE_MESSAGE,
            USER_DETAILS_OPTION + USER_DETAILS_MESSAGE,
            QUIT_SYSTEM_OPTION + QUIT_SYSTEM_DESCRIPTION};

    private ScannerLibrary scannerLibrary;

    private BooksDAO dao;

    private MoviesDAO movieDAO;

    private User user;

    public Menu() {
        movieDAO= new MoviesDAOImpl();
        dao = new BooksDAOImpl();
        scannerLibrary = new ScannerLibraryImpl();
    }

    public String getOptions() {
        String allOptions = "";
        for (String option :
                options) {
            allOptions += option + "\n";
        }
        return allOptions;
    }


    public String processInput(String input) {
        String output;

        output = new InputHandler(dao,movieDAO, scannerLibrary,user).handleInput(input);

        validateOutput(output);
        
        return output;
    }


    private void validateOutput(String output) {
        if (output == null) {
            throw new InvalidOptionArgRuntimeException(INVALID_OPTION_MESSAGE);
        }
    }

    public ScannerLibrary getScannerLibrary() {
        return scannerLibrary;
    }

    public void setScannerLibrary(ScannerLibrary scannerLibrary) {
        this.scannerLibrary = scannerLibrary;
    }

    public BooksDAO getDao() {
        return dao;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
