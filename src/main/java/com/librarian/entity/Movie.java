package com.librarian.entity;

public class Movie {

    private String name;
    private String year;
    private String director;
    private String rating;
    private boolean isInTheLibrary;

    @Override
    public String toString() {
        return
                "name=" + name +
                        " year=" + year +
                        " director=" + director +
                        " rating=" + rating;
    }

    public Movie(String name, String year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.isInTheLibrary=true;
    }

    public String getName() {
        return name;
    }

    public void checkOut() {
        this.isInTheLibrary = false;
    }

    public void checkIn() {
        this.isInTheLibrary = true;
    }

    public boolean isInTheLibrary() {
        return isInTheLibrary;
    }
}
