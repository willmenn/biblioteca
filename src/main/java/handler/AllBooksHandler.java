package handler;

import com.librarian.dao.BooksDAO;

public class AllBooksHandler implements ProcessInput {
    private static final String LIST_ALL_BOOKS_OPTION = "1";

    private BooksDAO dao;

    public AllBooksHandler(BooksDAO dao) {
        this.dao = dao;
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
