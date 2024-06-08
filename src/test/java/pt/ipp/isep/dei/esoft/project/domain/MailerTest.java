package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.application.controller.Mailer;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MailerTest {

    @Test
    void sendEmail() throws IOException {
        // Setup
        Mailer mailer = new Mailer();

        // Execute
        boolean result = mailer.sendEmail("from@example.com", "to@example.com", "Test Subject", "Test Body");

        // Assert
        assertTrue(result, "Email should be sent successfully");
    }

    // Add more tests as needed
}