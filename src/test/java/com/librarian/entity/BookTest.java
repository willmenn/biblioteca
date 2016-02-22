package com.librarian.entity;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookTest {


    @Test
    public void shouldCheckBookOut() {
        Book book = new Book("Titulo", "Julio", LocalDate.of(1991, Month.APRIL, 13));
        book.checkOut();
        assertFalse(book.isInTheLibrary());
    }

    @Test
    public void shouldCheckBookIn() {
        Book book = new Book("Titulo", "Julio", LocalDate.of(1991, Month.APRIL, 13));
        book.checkOut();
        book.checkIn();
        assertTrue(book.isInTheLibrary());
    }

}
