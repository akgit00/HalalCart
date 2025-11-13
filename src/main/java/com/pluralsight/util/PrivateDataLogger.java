package com.pluralsight.util;

import com.pluralsight.model.Order;
import com.pluralsight.model.MenuItems;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrivateDataLogger {

    private static final File EMAIL_LOG = new File("private_logs/emails_log.csv");
    private static final File RECEIPT_LOG = new File("private_logs/receipts_log.csv");

    static {
        File dir = new File("private_logs");
        dir.mkdirs();

    }

}