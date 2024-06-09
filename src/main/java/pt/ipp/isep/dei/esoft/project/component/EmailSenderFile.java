package pt.ipp.isep.dei.esoft.project.component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Implementation of EmailSender that writes email details to a file.
 */
public class EmailSenderFile implements EmailSender {

    /**
     * Sends an email by writing its details to a file.
     *
     * @param from    the sender's email address
     * @param to      the recipient's email address
     * @param subject the subject of the email
     * @param body    the body/content of the email
     * @return {@code true} if the email is sent successfully
     * @throws IOException if an I/O error occurs
     */
    @Override
    public boolean sendEmail(String from, String to, String subject, String body) throws IOException {
        // Create directory to store emails
        File dir = new File("./emails");
        dir.mkdirs();


        // Read existing email content, if any
        List<String> content = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("./emails/email.txt"));
            while (sc.hasNextLine()) {
                content.add(sc.nextLine());
            }
        } catch (FileNotFoundException ignored) {
            // If file not found, proceed without existing content
        }

        // Write email details to the file
        PrintWriter pw = new PrintWriter(new File("./emails/email.txt"));
        pw.println("From: " + from);
        pw.println("To: " + to);
        pw.println("Date: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        pw.println();
        pw.println("Subject: " + subject);
        pw.println("Body: " + body);
        pw.flush();

        return true;
    }
}
