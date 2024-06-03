package pt.ipp.isep.dei.esoft.project.application.controller;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.List;

public class Mailer {
    // ...
    static ConfigProperties config = new ConfigProperties();
    static String host = config.getProperty("host");
    static String port = config.getProperty("port");
    static String username = config.getProperty("username");
    static String password = config.getProperty("password");
    public static void sendEmailToMultipleRecipients(List<String> recipients, String subject, String text) {
        // Set up the SMTP server properties.
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); //TLS

        // Create the Session object.
        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@example.com"));

            // Add each recipient to the message.
            for (String recipient : recipients) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            }

            message.setSubject(subject);
            message.setText(text);

            // Send the message.
            Transport.send(message);

            System.out.println("Mail Sent Successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}