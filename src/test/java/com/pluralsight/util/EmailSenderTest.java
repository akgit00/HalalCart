package com.pluralsight.util;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;

public class EmailSenderTest {

    @Test
    void testEmailSenderInitialization() {
        //arrange: create sample sender credentials
        //act: create the EmailSender instance
        EmailSender sender = new EmailSender("halalcartnyc@gmail.com", "dummyPassword");

        //assert: verify object creation worked
        assertNotNull(sender, "EmailSender should be initialized");
    }

    @Test
    void testSendReceiptThrowsWhenInvalid() {
        //arrange: prepare invalid sender credentials and dummy file
        EmailSender sender = new EmailSender("invalid@example.com", "wrongpass");
        File dummyReceipt = new File("receipts/dummy.txt");

        //act: sending email with invalid credentials should throw an exception
        Exception exception = assertThrows(Exception.class, () -> {
            sender.sendReceipt("customer@example.com", dummyReceipt);
        });
        //assert: verify an error message exists
        assertNotNull(exception.getMessage());
    }
}