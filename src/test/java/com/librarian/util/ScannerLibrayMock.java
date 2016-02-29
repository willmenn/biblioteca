package com.librarian.util;

public class ScannerLibrayMock implements ScannerLibrary {

    private String responseFromScanner;

    public String createScanner() {
        return responseFromScanner;
    }

    public void setResponseFromScanner(String responseFromScanner) {
        this.responseFromScanner = responseFromScanner;
    }
}
