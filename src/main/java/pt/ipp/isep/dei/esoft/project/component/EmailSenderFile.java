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

public class EmailSenderFile implements EmailSender {
    @Override
    public boolean sendEmail(String from, String to, String subject, String body) throws IOException {
        File dir = new File("./emails");
        dir.mkdirs();
        List<String> content = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File("./emails/email.txt"));

            while (sc.hasNextLine()) {
                content.add(sc.nextLine());
            }
        } catch (FileNotFoundException ignored) {

        }


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
