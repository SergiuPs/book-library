package de.pislaru.sergiu.booklibrary.email.service;

import de.pislaru.sergiu.booklibrary.email.Email;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@Service
public class JavaMailSenderService implements EmailService {

    private final JavaMailSender emailSender;
    private final Configuration freeMarkerConfig;

    public JavaMailSenderService(JavaMailSender emailSender, @Qualifier("getFreeMarkerConfig") Configuration freeMarkerConfig) {
        this.emailSender = emailSender;
        this.freeMarkerConfig = freeMarkerConfig;
    }

    @Override
    public void sendEmail(Email email) throws MessagingException {

        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setTo(email.getTo());
        mimeMessageHelper.setFrom(email.getFrom().getValue());
        mimeMessageHelper.setSubject(email.getSubject().getValue());
        mimeMessageHelper.setText(email.getContent().getTextContent(), true);

        emailSender.send(mimeMessageHelper.getMimeMessage());
    }

    @Override
    public Template getTemplateFromString(String templateName) throws IOException {
        return freeMarkerConfig.getTemplate(templateName);
    }

}
