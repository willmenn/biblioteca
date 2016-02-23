package com.librarian.handler.processor;

import com.librarian.controller.Menu;
import com.librarian.dao.MoviesDAO;
import com.librarian.handler.ProcessBase;
import com.librarian.handler.ProcessInput;

public class AllMoviesHandler extends ProcessBase implements ProcessInput {

    public AllMoviesHandler(MoviesDAO dao) {
        super(null,dao, null);
    }

    public boolean accept(String input) {
        if(input.equals(Menu.LIST_ALL_MOVIES_OPTION)){
            return true;
        }
        return false;
    }

    public String processInput() {
        return movieDAO.getAllMoviesInTheLibrary().toString();
    }
}
