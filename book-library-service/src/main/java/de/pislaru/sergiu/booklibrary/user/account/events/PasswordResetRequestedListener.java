package de.pislaru.sergiu.booklibrary.user.account.events;

import de.pislaru.sergiu.booklibrary.email.*;
import de.pislaru.sergiu.booklibrary.email.service.EmailService;
import de.pislaru.sergiu.booklibrary.model.user.User;
import de.pislaru.sergiu.booklibrary.user.account.service.PasswordResetTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

@Component
public class PasswordResetRequestedListener implements ApplicationListener<OnPasswordResetRequestedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(UserRegistrationListener.class);

    private final EmailService emailService;
    private final PasswordResetTokenService passwordResetTokenService;

    public PasswordResetRequestedListener(EmailService emailService, PasswordResetTokenService passwordResetTokenService) {
        this.emailService = emailService;
        this.passwordResetTokenService = passwordResetTokenService;
    }

    @Override
    public void onApplicationEvent(OnPasswordResetRequestedEvent event) {
        User user = event.getUser();
        String token = passwordResetTokenService.createPasswordResetToken(user);
        String passwordResetUrl = event.getApplicationUrl() + EmailConstants.PASSWORD_RESET_PATH + token;

        Map<String, Object> templateModel = new HashMap<>();
        templateModel.put("firstName", user.getFirstName());
        templateModel.put("passwordResetUrl", passwordResetUrl);

        EmailContent emailContent = emailService.createEmailContent(EmailConstants.PASSWORD_RESET_TEMPLATE,
                                                                        templateModel, passwordResetUrl);
        Email email = new Email(user.getEmail(),
                EmailSender.NO_REPLY,
                EmailSubject.PASSWORD_RESET,
                emailContent);
        try {
            emailService.sendEmail(email);
        } catch (MessagingException e) {
            logger.error("Sending email validation failed: {}", e.getMessage());
            throw new RuntimeException(e);
        }

    }
}
