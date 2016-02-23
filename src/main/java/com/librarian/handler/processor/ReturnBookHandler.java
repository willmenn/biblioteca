package com.librarian.handler.processor;

import com.librarian.dao.BooksDAO;
import com.librarian.handler.ProcessBase;
import com.librarian.handler.ProcessInput;
import com.librarian.util.ScannerLibrary;

public class ReturnBookHandler extends ProcessBase implements ProcessInput {

    private static final String RETURN_BOOK_OPTION = "3";

    public ReturnBookHandler(BooksDAO dao, ScannerLibrary scannerLibrary) {
        super(dao, null,scannerLibrary);
    }

    public boolean accept(String input) {
        boolean isAccepted = false;
        if (input.equals(RETURN_BOOK_OPTION)) {
            isAccepted = true;
        }
        return isAccepted;
    }

    public String processInput() {
        askToWriteTheBookTitle();
        String bookTitle = getInputFromConsole();
        return bookDAO.checkInBook(bookTitle);
    }
}

