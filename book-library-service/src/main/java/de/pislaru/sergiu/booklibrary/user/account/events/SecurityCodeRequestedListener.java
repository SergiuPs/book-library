package de.pislaru.sergiu.booklibrary.user.account.events;

import de.pislaru.sergiu.booklibrary.email.*;
import de.pislaru.sergiu.booklibrary.email.service.EmailService;
import de.pislaru.sergiu.booklibrary.user.account.service.SecurityCodeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

@Component
public class SecurityCodeRequestedListener {

    private static final Logger logger = LoggerFactory.getLogger(SecurityCodeRequestedListener.class);

    private final EmailService emailService;
    private final SecurityCodeService securityCodeService;

    public SecurityCodeRequestedListener(EmailService emailService, SecurityCodeService securityCodeService) {
        this.emailService = emailService;
        this.securityCodeService = securityCodeService;
    }

    @EventListener
    public void sendSecurityCode(OnSecurityCodeRequestedEvent event) {
        String securityCode = securityCodeService.createSecurityCode(event.email());

        Map<String, Object> templateModel = new HashMap<>();
        templateModel.put("securityCode", securityCode);
        templateModel.put("firstName", event.firstName());

        EmailContent emailContent = emailService.createEmailContent(EmailConstants.SECURITY_CODE_TEMPLATE,
                                                                                    templateModel, securityCode);

        Email email = new Email(event.email(),
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
