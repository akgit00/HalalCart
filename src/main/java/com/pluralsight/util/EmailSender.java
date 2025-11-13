package com.pluralsight.util;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class EmailSender {
    private final String senderEmail;
    private final String senderPassword;

    public EmailSender(String senderEmail, String senderPassword) {
        this.senderEmail = senderEmail;
        this.senderPassword = senderPassword;
    }