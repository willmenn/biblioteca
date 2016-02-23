package com.librarian.handler.processor;

import com.librarian.handler.ProcessInput;

public class QuitSystem  implements ProcessInput {

    private static final String QUIT_SYSTEM_OPTION = "0";

    public boolean accept(String input) {
        boolean isAccepted = false;

        if (input.equals(QUIT_SYSTEM_OPTION)) {
            isAccepted = true;
        }
        return isAccepted;
    }

    public String processInput() {
        return "";
    }
}
