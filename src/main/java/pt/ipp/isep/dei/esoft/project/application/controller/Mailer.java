package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.component.EmailSender;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * This class handles the sending of emails to one or more recipients.
 * It uses SMTP settings loaded from a configuration file.
 */
public class Mailer implements EmailSender {
    // Configuration properties
    ConfigProperties config = new ConfigProperties();
    String host = config.getProperty("host");
    String port = config.getProperty("port");
    String username = config.getProperty("username");
    String password = config.getProperty("password");

    /**
     * Sends an email to multiple recipients.
     *
     * @param recipients List of recipient email addresses.
     * @param subject    The subject of the email.
     * @param text       The text content of the email.
     */
    public void sendEmailToMultipleRecipients(List<String> recipients, String subject, String text) {
        // Set up the SMTP server properties.
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true"); // Enable TLS

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

            // Set the subject and content of the email.
            message.setSubject(subject);
            message.setText(text);

            // Send the message.
            Transport.send(message);

            System.out.println("Mail Sent Successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sends an email to a single recipient.
     *
     * @param from    The sender's email address.
     * @param to      The recipient's email address.
     * @param subject The subject of the email.
     * @param body    The text content of the email.
     * @return {@code true} if the email was sent successfully.
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public boolean sendEmail(String from, String to, String subject, String body) throws IOException {
        sendEmailToMultipleRecipients(List.of(to), subject, body);
        return true;
    }
}
