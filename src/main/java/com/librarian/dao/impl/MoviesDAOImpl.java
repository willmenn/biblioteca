package com.librarian.dao.impl;

import com.librarian.dao.MoviesDAO;
import com.librarian.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MoviesDAOImpl implements MoviesDAO {

    private List<Movie> movies;

    public MoviesDAOImpl(){
        movies= buildMovies();
    }

public List<Movie> buildMovies(){
    List<Movie> movies = new ArrayList<Movie>();
    movies.add(new Movie("Harry Potter", "J K Rolling", "1233","*"));
    movies.add(new Movie("Star Wars", "George Lucas", "2000","*"));
    return movies;
}
    public boolean insertMovie(Movie movie) {
       return movies.add(movie);
    }

    public String getAllMovies() {
        return movies.toString();
    }

}
