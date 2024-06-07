package pt.ipp.isep.dei.esoft.project.component;

import java.io.IOException;

public interface EmailSender {

    boolean sendEmail(String from, String to, String subject, String body) throws IOException;


}
