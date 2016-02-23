package com.librarian.handler.processor;

import com.librarian.dao.BooksDAO;
import com.librarian.handler.ProcessBase;
import com.librarian.handler.ProcessInput;

public class AllBooksHandler  extends ProcessBase implements ProcessInput {

    private static final String LIST_ALL_BOOKS_OPTION = "1";

    public AllBooksHandler(BooksDAO dao) {
        super(dao,null);
    }

    public boolean accept(String input) {
        boolean isAccepted = false;
        if (input.equals(LIST_ALL_BOOKS_OPTION)) {
            isAccepted = true;

        }
        return isAccepted;
    }

    public String processInput() {
        return dao.getAllBooks().toString();
    }
}
