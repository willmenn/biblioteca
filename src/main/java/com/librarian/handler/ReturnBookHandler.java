package com.librarian.handler;

import com.librarian.controller.Menu;
import com.librarian.dao.BooksDAO;
import com.librarian.util.ScannerLibrary;

public class ReturnBookHandler implements ProcessInput {

    private static final String RETURN_BOOK_OPTION = "3" ;

    private BooksDAO dao;

    private ScannerLibrary scannerLibrary;

    public ReturnBookHandler(BooksDAO dao, ScannerLibrary scannerLibrary) {
        this.dao = dao;
        this.scannerLibrary = scannerLibrary;
    }

    public boolean accept(String input) {
        boolean isAccepted=false;
        if (input.equals(RETURN_BOOK_OPTION)) {
            isAccepted=true;
        }
        return isAccepted;
    }

    public String processInput() {
        askToWriteTheBookTitle();
        String bookTitle = getInputFromConsole();
        return dao.checkInBook(bookTitle);
    }

    private void askToWriteTheBookTitle() {
        System.out.println(Menu.MESSAGE_TO_ASK_BOOK_TITLE);
    }

    private String getInputFromConsole() {
        return scannerLibrary.createScanner();
    }
}

