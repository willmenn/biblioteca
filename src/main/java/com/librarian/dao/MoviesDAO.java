package com.librarian.dao;

import com.librarian.entity.Movie;

import java.util.List;

public interface MoviesDAO {

    String MOVIE_NOT_AVAILABLE_MESSAGE = "That movie is not avaliable.";
    String MOVIE_IS_AVAILABLE_MESSAGE = "Thank you! Enjoy the movie";
    String CHECKIN_SUCCESSFUL_MESSAGE= "Thank you for returning the movie.";
    String CHECKIN_FAIL_MESSAGE="That is not a valid movie to return.";

    boolean insertMovie(Movie movie);

    List<Movie> getAllMoviesInTheLibrary();

    String checkoutMovieByName(String name);

    String checkInMovie(String name);
}
