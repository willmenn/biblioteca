package com.librarian.handler.processor;

import com.librarian.controller.Menu;
import com.librarian.dao.MoviesDAO;
import com.librarian.handler.ProcessBase;
import com.librarian.handler.ProcessInput;
import com.librarian.util.ScannerLibrary;

public class CheckMOvieOutHandler extends ProcessBase implements ProcessInput {

    public CheckMOvieOutHandler( MoviesDAO movieDAO, ScannerLibrary scannerLibrary) {
        super(null, movieDAO, scannerLibrary);
    }

    public boolean accept(String input) {
        if(input.equals(Menu.CHECKOUT_MOVIE_OPTION)){
            return true;
        }
        return false;
    }

    public String processInput() {
        askToWriteTheBookTitle();
        String movieName = getInputFromConsole();
        return movieDAO.checkoutMovieByName(movieName);
    }
}
