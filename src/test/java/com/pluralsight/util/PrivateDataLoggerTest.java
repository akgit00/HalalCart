package com.pluralsight.util;

import com.pluralsight.model.MenuItems;
import com.pluralsight.model.Order;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import static org.junit.jupiter.api.Assertions.*;

public class PrivateDataLoggerTest {

    private static final File EMAIL_LOG = new File("private_logs/emails_log.csv");
    private static final File RECEIPT_LOG = new File("private_logs/receipts_log.csv");

    @BeforeEach
    void cleanLogs() {
        //arrange: clean up any old log files before each test
        EMAIL_LOG.delete();
        RECEIPT_LOG.delete();
    }

    @Test
    void testEmailLogCreationAndWrite() throws Exception {
        //arrange: prepare dummy email and file to log
        File dummyReceipt = new File("receipt_test.txt");

        //act: log an email entry (this should create a file if it's missing)
        PrivateDataLogger.logEmail("customer@example.com", new File("receipt_test.txt"));

        //assert: verify the log file exists and contains the email
        assertTrue(EMAIL_LOG.exists(), "Email log file should exist after logging");
        String logContents = Files.readString(EMAIL_LOG.toPath());
        assertTrue(logContents.contains("customer@example.com"), "Customer email should be logged");
    }

    @Test
    void testReceiptLogCreationAndWrite() throws Exception {
        //arrange: create a sample order with one item
        Order order = new Order();
        order.addItem(new MenuItems("Falafel Wrap", "Medium", 8.50) {
            @Override
            public String getDescription() {
                return "";
            }
        });

        //act: log the order receipt
        PrivateDataLogger.logReceipt(order, new File("receipt_test.txt"));

        //assert: verify the log file exists and includes the item name
        assertTrue(RECEIPT_LOG.exists(), "Receipt log file should exist");
        String logContents = Files.readString(RECEIPT_LOG.toPath());
        assertTrue(logContents.contains("Falafel Wrap"), "Item name should appear in the log");
    }
}