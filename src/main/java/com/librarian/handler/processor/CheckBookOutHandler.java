package com.librarian.handler.processor;

import com.librarian.dao.BooksDAO;
import com.librarian.handler.ProcessBase;
import com.librarian.handler.ProcessInput;
import com.librarian.util.ScannerLibrary;

public class CheckBookOutHandler extends ProcessBase implements ProcessInput {

    private static final String CHECKOUT_OPTION = "2";

    public CheckBookOutHandler(BooksDAO dao, ScannerLibrary scannerLibrary) {
        super(dao,null, scannerLibrary,null);
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
        String statusCheckout = bookDAO.checkoutBookByTitle(bookName);
        return statusCheckout;
    }

}
