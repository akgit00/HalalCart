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

    public void sendReceipt(String recipientEmail, File receiptFile) throws Exception {
        //configure gmail SMTP
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        //authenticate with gmail
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            //create the message
            Message message = new MimeMessage(session);

            //the "from" field (business Gmail + display name)
            message.setFrom(new InternetAddress(senderEmail, "Halal NYC Cart"));

            //the "reply to" for potential support email
            message.setReplyTo(InternetAddress.parse(senderEmail));

            //the "to" field (the customer)
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));

            //subject line
            message.setSubject("Your Halal NYC Cart Receipt");

            //email body
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText("""
                    Thank you for ordering from the Halal NYC Cart!
                    Your meal is being prepared fresh and delicious.
                    
                    Please find your receipt attached below.
                    
                    Come back soon!
                    """);

            //receipt attachment here
            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(receiptFile);

            //combine email sections
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(attachmentPart);
            message.setContent(multipart);

            //send email to customer
            Transport.send(message);
            System.out.println("Receipt email sent successfully to " + recipientEmail);

            //first catch in case authentication failed
        } catch (AuthenticationFailedException e) {
            System.err.println("Gmail authentication failed: Check your app password.");
            throw e;
        }//catch in case of invalid character encoding
        catch (UnsupportedEncodingException e) {
            System.err.println("Invalid character encoding for sender name.");
            throw e;
        }//catch in case the receipt is unable to be sent
        catch (Exception e) {
            System.err.println("❌ Failed to send receipt: " + e.getMessage());
            throw e;
        }
    }
}