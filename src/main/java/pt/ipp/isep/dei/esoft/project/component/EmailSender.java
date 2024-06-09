package pt.ipp.isep.dei.esoft.project.component;

import java.io.IOException;

/**
 * The EmailSender interface represents a component responsible for sending emails.
 * Implementations of this interface should provide methods to send emails from one email address to another.
 */
public interface EmailSender {

    /**
     * Sends an email with the specified details.
     *
     * @param from    the sender's email address
     * @param to      the recipient's email address
     * @param subject the subject of the email
     * @param body    the body content of the email
     * @return true if the email is sent successfully, false otherwise
     * @throws IOException if an I/O error occurs while sending the email
     */
    boolean sendEmail(String from, String to, String subject, String body) throws IOException;
}
