package com.librarian;

import com.librarian.dao.impl.BooksDAOImpl;
import com.librarian.controller.Menu;

public class App {

    public static void main(String[] args) {

        printWelcome();
        Menu menu = new Menu();
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

    private static void printWelcome() {
        System.out.println(new WelcomeMessage().getWelcomeMessage());

        System.out.println("All Books:");
        System.out.println(new BooksDAOImpl().getAllBooks());
    }
}
