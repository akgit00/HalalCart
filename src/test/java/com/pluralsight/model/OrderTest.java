package com.pluralsight.model;

import org.junit.jupiter.api.*;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    private Order order;

    @BeforeEach
    void setUp() {
        //arrange: Create a new order and add some items before each test
        order = new Order();
        order.addItem(new MenuItems("Halal Plate", "Large", 10.00) {
            @Override
            public String getDescription() {
                return "";
            }
        });
        order.addItem(new MenuItems("Drink", "Medium", 2.50) {
            @Override
            public String getDescription() {
                return "";
            }
        });
    }

    @Test
    void testOrderTotalCalculation() {
        //arrange: the order is already prepared in setUp()
        //act: get the total from the order
        double total = order.getTotal();
        //assert: verify that the total equals 12.50
        assertEquals(12.50, order.getTotal(), 0.01, "Total should be sum of all item prices");
    }

    @Test
    void testSaveReceiptCreatesFile() {
        //arrange: order with items already exists

        //act: save the receipt (this should create a receipts folder and file)
        order.saveReceipt();
        File dir = new File("receipts");

        //assert: verify that receipts directory and file exist
        assertTrue(dir.exists(), "Receipts directory should exist");
        assertTrue(dir.listFiles().length > 0, "Receipt file should be created");
    }
}