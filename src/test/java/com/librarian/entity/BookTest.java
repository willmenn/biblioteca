package com.librarian.entity;

import com.librarian.entity.builder.BookBuilder;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.*;

public class BookTest {

    private Book book;

    @Before
    public void setUp() {
        book = new Book();
    }

    @Test
    public void shouldBuildBook() {
        assertNotNull(book);
    }

    @Test
    public void shouldBuildBookWithTitle() {
        String title = "Harry Potter";
        book.setTitle(title);
        assertEquals(title, book.getTitle());
    }

    @Test
    public void shouldBuildBookWithAuthor() {
        String author = "J.k. Rolling";
        book.setAuthor(author);
        assertEquals(author, book.getAuthor());
    }

    @Test
    public void shouldBuildWithYearPublished() {
        LocalDate localDate = LocalDate.of(1998, 03, 06);
        book.setYearPublish(localDate);
        assertThat(book.getYearPublish(), LocalDateMatchers.isMarch());
        assertThat(book.getYearPublish(), LocalDateMatchers.isDayOfMonth(06));
        assertThat(book.getYearPublish(), LocalDateMatchers.isYear(1998));
    }

    @Test
    public void shouldPrintBook() {
        String author = "Joao";
        String title = "Fundacao";
        LocalDate yearPublish = LocalDate.of(2000, Month.DECEMBER, 9);
        Book book = new BookBuilder().withAuthor(author).withTitle(title).withYearPublished(yearPublish).build();
        String expected = "title='" + title + '\t' +
                ", author='" + author + '\t' +
                ", yearPublish='" + yearPublish +
                '\n';
        assertEquals(expected, book.toString());
    }

    @Test
    public void shouldCheckoutBook(){
        Book  book= new Book();
        book.setCheckout(true);
        assertTrue(book.isCheckout());
    }

    @Test
    public void shouldBeNotCheckout(){
        Book book = new Book();
        assertFalse(book.isCheckout());
    }

}
