package com.librarian;

import com.librarian.dao.impl.BooksDAOImpl;
import com.librarian.controller.Menu;

public class App {

    public static final String PRINT_ALL_BOOKS = "1";

    public static void main(String[] args) {

        Menu menu = new Menu();
        printWelcome(menu);
        System.out.println(menu.getOptions());
        String input = "";

        while (!input.equals("0")) {
            input = menu.getScannerLibrary().createScanner();
            String output;
            try {
                output = menu.processInput(input);
            } catch (RuntimeException exception) {
                output = exception.getMessage();
            }
            System.out.println(output);
        }

        System.out.println("Closing the System.");

    }

    private static void printWelcome(Menu menu) {
        System.out.println(new WelcomeMessage().getWelcomeMessage());

        System.out.println("All Books:");
        System.out.println(menu.processInput(PRINT_ALL_BOOKS));
    }
}
