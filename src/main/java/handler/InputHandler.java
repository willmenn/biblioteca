package handler;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    private List<ProcessInput> handlers;

    public InputHandler() {
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
        handlers.add(new AllBooksHandler());

        return handlers;
    }

}
