package de.pislaru.sergiu.booklibrary.user.account.events;

import de.pislaru.sergiu.booklibrary.email.*;
import de.pislaru.sergiu.booklibrary.email.service.EmailService;
import de.pislaru.sergiu.booklibrary.model.user.User;
import de.pislaru.sergiu.booklibrary.user.account.service.VerificationTokenService;
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
public class UserRegistrationListener implements ApplicationListener<OnUserRegistrationCompleteEvent> {

    private static final Logger logger = LoggerFactory.getLogger(UserRegistrationListener.class);

    private final VerificationTokenService tokenService;
    private final EmailService emailService;

    public UserRegistrationListener(VerificationTokenService tokenService, EmailService emailService) {
        this.tokenService = tokenService;
        this.emailService = emailService;
    }

    @Override
    public void onApplicationEvent(OnUserRegistrationCompleteEvent event) {
        User user = event.getUser();
        String token = tokenService.createVerificationToken(user);

        String confirmationUrl = event.getApplicationUrl() + EmailConstants.CONFIRM_REGISTRATION_PATH + token;
        Map<String, Object> templateModel = new HashMap<>();
        templateModel.put("firstName", user.getFirstName());
        templateModel.put("lastName", user.getLastName());
        templateModel.put("confirmationLink", confirmationUrl);

        EmailContent emailContent = emailService.createEmailContent(EmailConstants.EMAIL_CONFIRMATION_LINK_TEMPLATE,
                                                                                    templateModel, confirmationUrl);

        Email email = new Email("sergiu.pislaru@web.de",
                EmailSender.NO_REPLY,
                EmailSubject.REGISTRATION_CONFIRMATION,
                emailContent);
        try {
            emailService.sendEmail(email);
        } catch (MessagingException e) {
            logger.error("Sending email validation failed: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
