package handler;

import com.librarian.dao.BooksDAO;
import com.librarian.util.ScannerLibrary;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    private List<ProcessInput> handlers;

    private BooksDAO dao;

    private ScannerLibrary scannerLibrary;

    public InputHandler(BooksDAO dao, ScannerLibrary scannerLibrary) {
        this.dao = dao;
        this.scannerLibrary = scannerLibrary;
        handlers = buildHandlers();
    }

    public String handleInput(String input) {
        boolean isAccept = false;
        int count = 0;
        while (!isAccept) {
            if (count == handlers.size()) {
                isAccept = true;
            } else if (handlers.get(count).accept(input)) {
                return handlers.get(count).processInput();
            }
            count = count + 1;
        }
        return null;
    }

    private List<ProcessInput> buildHandlers() {
        handlers = new ArrayList<ProcessInput>();
        handlers.add(new AllBooksHandler(dao));
        handlers.add(new CheckBookOutHandler(dao, scannerLibrary));
        handlers.add(new ReturnBookHandler(dao,scannerLibrary));
        return handlers;
    }


}
