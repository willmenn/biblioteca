package com.librarian.handler.processor;

import com.librarian.controller.Menu;
import com.librarian.dao.MoviesDAO;
import com.librarian.handler.ProcessBase;
import com.librarian.handler.ProcessInput;
import com.librarian.util.ScannerLibrary;

public class CheckMovieInHandler extends ProcessBase implements ProcessInput{

    public CheckMovieInHandler(MoviesDAO movieDAO, ScannerLibrary scannerLibrary) {
        super(null, movieDAO, scannerLibrary);
    }

    public boolean accept(String input) {
        boolean isAccepted= false;
       if(input.equals(Menu.CHECKIN_MOVIE_OPTION)){
           isAccepted=true;
       }
        return isAccepted;
    }

    public String processInput() {
        askToWriteTheBookTitle();
        String movieName = getInputFromConsole();
        return movieDAO.checkInMovie(movieName);
    }
}
