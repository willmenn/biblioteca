package com.librarian.handler;

import com.librarian.controller.Menu;
import com.librarian.dao.BooksDAO;
import com.librarian.dao.MoviesDAO;
import com.librarian.util.ScannerLibrary;

public class ProcessBase {

    protected BooksDAO bookDAO;

    protected MoviesDAO movieDAO;

    private ScannerLibrary scannerLibrary;

    public ProcessBase(BooksDAO dao,MoviesDAO movieDAO, ScannerLibrary scannerLibrary) {
        this.bookDAO = dao;
        this.movieDAO=movieDAO;
        this.scannerLibrary = scannerLibrary;
    }

    protected void askToWriteTheBookTitle() {
        System.out.println(Menu.MESSAGE_TO_ASK_FOR_THE_NAME);
    }

    protected String getInputFromConsole() {
        return scannerLibrary.createScanner();
    }
}
