package com.librarian.util;

import java.util.Scanner;

public class ScannerLibraryImpl implements ScannerLibrary {


    public String createScanner() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        return input;
    }
}
