package com.librarian.handler;

import com.librarian.controller.Menu;
import com.librarian.dao.BooksDAO;
import com.librarian.util.ScannerLibrary;

public class ProcessBase {

    protected BooksDAO dao;

    private ScannerLibrary scannerLibrary;

    public ProcessBase(BooksDAO dao, ScannerLibrary scannerLibrary) {
        this.dao = dao;
        this.scannerLibrary = scannerLibrary;
    }

    protected void askToWriteTheBookTitle() {
        System.out.println(Menu.MESSAGE_TO_ASK_BOOK_TITLE);
    }

    protected String getInputFromConsole() {
        return scannerLibrary.createScanner();
    }
}
