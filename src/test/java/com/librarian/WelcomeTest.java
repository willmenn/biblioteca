package com.librarian;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WelcomeTest {


    @Test
    public void shouldPrintWelcomeMessage() {
        WelcomeMessage welcomeMessage = new WelcomeMessage();
        String welcomeMessageTobePrinted = welcomeMessage.getWelcomeMessage();
        assertEquals(WelcomeMessage.WELCOME_MESSAGE, welcomeMessageTobePrinted);
    }

}
