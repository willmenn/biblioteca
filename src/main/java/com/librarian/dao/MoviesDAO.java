package com.librarian.dao;

import com.librarian.entity.Movie;

public interface MoviesDAO {

    boolean insertMovie(Movie movie);

    String getAllMovies();

}
