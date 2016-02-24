package com.librarian.handler.processor;

import com.librarian.controller.Menu;
import com.librarian.entity.User;
import com.librarian.handler.ProcessBase;
import com.librarian.handler.ProcessInput;

public class UserDetailsHandler extends ProcessBase implements ProcessInput{
    public UserDetailsHandler(User user) {
        super(null, null, null,user);
    }

    public boolean accept(String input) {
        boolean isAccepted=false;
        if(input.equals(Menu.USER_DETAILS_OPTION)){
            isAccepted=true;
        }
        return isAccepted;
    }

    public String processInput() {
        return user.toString();
    }
}
