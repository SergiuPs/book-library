package de.pislaru.sergiu.booklibrary.email.service;

import de.pislaru.sergiu.booklibrary.email.Email;
import de.pislaru.sergiu.booklibrary.email.EmailContent;
import freemarker.template.Template;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Map;

public interface EmailService {
    void sendEmail(Email email) throws MessagingException;
    EmailContent createEmailContent(String templateName, Map<String, Object> templateModel, String textContent);

}
