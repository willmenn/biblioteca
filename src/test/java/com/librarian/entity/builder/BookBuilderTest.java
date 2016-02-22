package com.librarian.entity.builder;

import com.librarian.entity.Book;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.*;

public class BookBuilderTest {

    @Test
    public void shouldBuildBook() {
        Book book = new BookBuilder().build();
        assertNotNull(book);
    }

    @Test
    public void shouldBuildBookWithTitle() {
        String title = "Senhor dos Aneis";
        Book book = new BookBuilder().withTitle(title).build();
        assertEquals(title, book.getTitle());
    }

    @Test
    public void shouldBuildBookWithAuthor() {
        String author = "Tolkien";
        Book book = new BookBuilder().withAuthor(author).build();
        assertEquals(author, book.getAuthor());
    }

    @Test
    public void shouldBuildBookWithYearPublishied() {
        LocalDate date = LocalDate.of(2000, Month.APRIL, 10);
        Book book = new BookBuilder().withYearPublished(date).build();
        assertThat(book.getYearPublish(), LocalDateMatchers.isApril());
        assertThat(book.getYearPublish(), LocalDateMatchers.isDayOfMonth(date.getDayOfMonth()));
        assertThat(book.getYearPublish(), LocalDateMatchers.isYear(date.getYear()));

    }

    @Test
    public void shouldBuildBookWithNotCheckout(){
        Book book = new BookBuilder().build();
        assertFalse(book.isCheckout());
    }

    @Test
    public void shouldBuildACheckoutBook(){
        Book  book = new BookBuilder().checkoutBook().build();
        assertTrue(book.isCheckout());
    }

}
