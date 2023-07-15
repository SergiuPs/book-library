package de.pislaru.sergiu.booklibrary.email.service;

import de.pislaru.sergiu.booklibrary.email.Email;
import freemarker.template.Template;

import javax.mail.MessagingException;
import java.io.IOException;

public interface EmailService {
    void sendEmail(Email email) throws MessagingException;
    Template getTemplateFromString(String templateName) throws IOException;
}
