package handler;

import com.librarian.dao.BooksDAO;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    private List<ProcessInput> handlers;

    private BooksDAO  dao;

    public InputHandler(BooksDAO dao) {
        this.dao=dao;
        handlers = buildHandlers();
    }

    public String handleInput(String input) {
        boolean isAccept = false;
        int count = 0;
        while (!isAccept) {
            if (count == handlers.size()) {
                isAccept = true;
            } else if (handlers.get(count).accept(input)) {
                   return handlers.get(count).processInput(input);
            }
            count = +1;
        }
    return  null;
}

    private List<ProcessInput> buildHandlers() {
        handlers = new ArrayList<ProcessInput>();
        handlers.add(new AllBooksHandler(dao));

        return handlers;
    }

    public InputHandler setBookDAO(BooksDAO dao){
        this.dao=dao;
        return this;
    }

}
