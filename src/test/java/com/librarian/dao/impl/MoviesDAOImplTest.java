package com.librarian.dao.impl;

import com.librarian.dao.MoviesDAO;
import com.librarian.entity.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MoviesDAOImplTest {

    private MoviesDAO dao;

    @Before
    public void setUp() {
        dao = new MoviesDAOImpl();
    }

    @Test
    public void insertMovie() {
        boolean isMovieInserted = dao.insertMovie(new Movie("Indiana Jones", "1990", "", ""));
        assertTrue(isMovieInserted);
    }

    @Test
    public void shouldGetAllMovies() {
        List<Movie> movies = dao.getAllMoviesInTheLibrary();
        assertNotNull(movies);
    }

    @Test
    public void shouldCheckMovieOut() {
        String successfulCheckoutMessage = dao.checkoutMovieByName("Harry Potter");
        assertEquals(MoviesDAO.MOVIE_IS_AVAILABLE_MESSAGE, successfulCheckoutMessage);
    }

    @Test
    public void shouldNotCheckMovieOut() {
        String unSuccessfulCheckoutMessage = dao.checkoutMovieByName("Indiana Jones");
        assertEquals(MoviesDAO.MOVIE_NOT_AVAILABLE_MESSAGE, unSuccessfulCheckoutMessage);
    }

    @Test
    public void shouldCheckMovieIn() {
        dao.checkoutMovieByName("Harry Potter");
        String successfulCheckin = dao.checkInMovie("Harry Potter");
        assertEquals(MoviesDAO.CHECKIN_SUCCESSFUL_MESSAGE, successfulCheckin);
    }

    @Test
    public void shouldNotCheckin(){
        String unsuccesfulCheckin = dao.checkInMovie("Indian Jones");
        assertEquals(MoviesDAO.CHECKIN_FAIL_MESSAGE,unsuccesfulCheckin);
    }
}

