package com.librarian.dao.impl;

import com.librarian.dao.MoviesDAO;
import com.librarian.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MoviesDAOImpl implements MoviesDAO {

    private List<Movie> movies;

    public MoviesDAOImpl() {
        movies = buildMovies();
    }

    public List<Movie> buildMovies() {
        List<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Harry Potter", "J K Rolling", "1233", "*"));
        movies.add(new Movie("Star Wars", "George Lucas", "2000", "*"));
        return movies;
    }

    public boolean insertMovie(Movie movie) {
        return movies.add(movie);
    }

    public List<Movie> getAllMoviesInTheLibrary() {

        List<Movie> availableMovies = new ArrayList<Movie>();
        for (Movie movie :
                movies) {
            if (movie.isInTheLibrary()) {
                availableMovies.add(movie);
            }
        }
        return availableMovies;
    }

    public String checkoutMovieByName(String name) {
        boolean isSuccessfulCheckout = false;
        for (Movie movie : getAllMoviesInTheLibrary()) {
            if (movie.getName().equals(name)) {
                movie.checkOut();
                isSuccessfulCheckout = true;
            }
        }

        if (!isSuccessfulCheckout) {
            return MOVIE_NOT_AVAILABLE_MESSAGE;
        }
        return MOVIE_IS_AVAILABLE_MESSAGE;
    }

    public String checkInMovie(String name) {
        boolean isSuccesfullCheckIn = false;
        for (Movie movie : movies) {
            if ((movie.getName().equals(name)) && (!movie.isInTheLibrary())) {
                movie.checkIn();
                isSuccesfullCheckIn = true;
            }
        }

        if (!isSuccesfullCheckIn) {
            return CHECKIN_FAIL_MESSAGE;
        }

        return CHECKIN_SUCCESSFUL_MESSAGE;
    }
}
