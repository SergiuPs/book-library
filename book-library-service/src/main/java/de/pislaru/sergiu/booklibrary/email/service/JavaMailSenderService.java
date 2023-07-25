package de.pislaru.sergiu.booklibrary.email.service;

import de.pislaru.sergiu.booklibrary.email.Email;
import de.pislaru.sergiu.booklibrary.email.EmailContent;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Map;

@Service
public class JavaMailSenderService implements EmailService {

    private static final Logger logger = LoggerFactory.getLogger(JavaMailSenderService.class);

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
    public EmailContent createEmailContent(String templateName, Map<String, Object> templateModel, String textContent) {
        try {
            Template template = getTemplateFromString(templateName);
            return new EmailContent(template, templateModel);
        } catch (IOException | TemplateException e) {
            logger.error("Loading template failed: {}", e.getMessage());
            return new EmailContent(textContent);
        }
    }

    private Template getTemplateFromString(String templateName) throws IOException {
        return freeMarkerConfig.getTemplate(templateName);
    }

}
