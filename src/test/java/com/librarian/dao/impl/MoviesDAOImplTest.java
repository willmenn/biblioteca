package com.librarian.dao.impl;

import com.librarian.dao.MoviesDAO;
import com.librarian.entity.Movie;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        String allMovies = dao.getAllMovies();
        String expected = "[name='Harry Potter year='J K Rolling director='1233 rating='*," +
                " name='Star Wars year='George Lucas director='2000 rating='*]";
        assertEquals(expected, allMovies);
    }
}

