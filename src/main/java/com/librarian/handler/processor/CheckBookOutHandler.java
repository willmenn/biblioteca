package com.librarian.handler.processor;

import com.librarian.controller.Menu;
import com.librarian.dao.BooksDAO;
import com.librarian.handler.ProcessInput;
import com.librarian.util.ScannerLibrary;

public class CheckBookOutHandler implements ProcessInput {

    private static final String CHECKOUT_OPTION = "2";

    private BooksDAO dao;

    private ScannerLibrary scannerLibrary;

    public CheckBookOutHandler(BooksDAO dao, ScannerLibrary scannerLibrary) {
        this.dao = dao;
        this.scannerLibrary = scannerLibrary;
    }

    public boolean accept(String input) {
        boolean isAccepted = false;
        if (input.equals(CHECKOUT_OPTION)) {
            isAccepted = true;
        }
        return isAccepted;
    }

    public String processInput() {
        askToWriteTheBookTitle();
        String bookName = getInputFromConsole();
        String statusCheckout = dao.checkoutBookByTitle(bookName);
        return statusCheckout;
    }

    private void askToWriteTheBookTitle() {
        System.out.println(Menu.MESSAGE_TO_ASK_BOOK_TITLE);
    }

    private String getInputFromConsole() {
        return scannerLibrary.createScanner();
    }
}
