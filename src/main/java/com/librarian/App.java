package com.librarian;

import com.librarian.controller.Menu;
import com.librarian.dao.UserDAO;
import com.librarian.dao.impl.UserDAOImpl;
import com.librarian.entity.User;

public class App {

    public static final String PRINT_ALL_BOOKS = "1";

    public static void main(String[] args) {

        Menu menu = new Menu();
        performLogin(menu);
        printWelcome(menu);
        printMenuOptions(menu);
        String input = "";

        while (!input.equals("0")) {

            input = menu.getScannerLibrary().createScanner();
            String output;

            try {
                output = menu.processInput(input);
            } catch (RuntimeException exception) {
                output = exception.getMessage();
            }

            System.out.println(output + "\n");
            printMenuOptions(menu);
        }

        System.out.println("Closing the System.");

    }

    private static void printMenuOptions(Menu menu) {

        System.out.println("\n" + "Menu Options:\n");

        System.out.println(menu.getOptions());
    }

    private static void printWelcome(Menu menu) {

        System.out.println(new WelcomeMessage().getWelcomeMessage());

        System.out.println("All Books:");

        System.out.println(menu.processInput(PRINT_ALL_BOOKS));
    }

    private static void performLogin(Menu menu) {

        UserDAO dao = new UserDAOImpl();

        boolean isLogged = false;
        while (!isLogged) {
            System.out.println("Write your library number:\n");
            String libraryNumber = menu.getScannerLibrary().createScanner();

            System.out.println("Write your password:");
            String pass = menu.getScannerLibrary().createScanner();

            System.out.println("Performing Login, wait a minute.");
            User userLogged = dao.login(libraryNumber, pass);
            if (userLogged == null) {
                System.out.println("Error in Login, plz try again.");
            }else {
                isLogged=true;
            }

        }


    }

}
