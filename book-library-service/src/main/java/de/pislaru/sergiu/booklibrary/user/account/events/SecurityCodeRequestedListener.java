package de.pislaru.sergiu.booklibrary.user.account.events;

import de.pislaru.sergiu.booklibrary.email.*;
import de.pislaru.sergiu.booklibrary.email.service.EmailService;
import de.pislaru.sergiu.booklibrary.model.user.User;
import de.pislaru.sergiu.booklibrary.user.account.service.SecurityCodeService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class SecurityCodeRequestedListener implements ApplicationListener<OnSecurityCodeRequestedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(UserRegistrationListener.class);

    private final EmailService emailService;
    private final SecurityCodeService securityCodeService;

    public SecurityCodeRequestedListener(EmailService emailService, SecurityCodeService securityCodeService) {
        this.emailService = emailService;
        this.securityCodeService = securityCodeService;
    }

    @Override
    public void onApplicationEvent(OnSecurityCodeRequestedEvent event) {
        User user = event.getUser();
        String securityCode = securityCodeService.createSecurityCode(user.getEmail());

        Map<String, Object> templateModel = new HashMap<>();
        templateModel.put("securityCode", securityCode);
        templateModel.put("firstName", user.getFirstName());

        EmailContent emailContent;
        try {
            Template template = emailService.getTemplateFromString(EmailConstants.EMAIL_SECURITY_CODE_TEMPLATE);
            emailContent = new EmailContent(template, templateModel);
        } catch (IOException | TemplateException e) {
            logger.error("Loading template failed: {}", e.getMessage());
            emailContent = new EmailContent(securityCode);
        }

        Email email = new Email(user.getEmail(),
                EmailSender.NO_REPLY,
                EmailSubject.SECURITY_CODE,
                emailContent);
        try {
            emailService.sendEmail(email);
        } catch (MessagingException e) {
            logger.error("Sending security code failed: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
