package handler;

import com.librarian.dao.BooksDAO;
import com.librarian.dao.impl.BooksDAOImpl;

public class AllBooksHandler implements ProcessInput {
    private static final String LIST_ALL_BOOKS_OPTION = "1";

    private BooksDAO dao;

    public AllBooksHandler() {
        dao = new BooksDAOImpl();
    }

    public boolean accept(String input) {
        boolean isAccpeted = false;
        if (input.equals(LIST_ALL_BOOKS_OPTION)) {
            isAccpeted = true;

        }
        return isAccpeted;
    }

    public String processInput(String inputf) {
        return dao.getAllBooks().toString();
    }
}
