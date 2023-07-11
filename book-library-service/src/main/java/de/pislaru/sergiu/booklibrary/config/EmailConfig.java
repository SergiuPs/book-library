package de.pislaru.sergiu.booklibrary.config;

import de.pislaru.sergiu.booklibrary.constants.EmailConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfig {

    @Value("${book.library.email.host}")
    private String host;
    @Value("${book.library.email.port}")
    private int port;
    @Value("${book.library.email.user}")
    private String user;
    @Value("${book.library.email.password}")
    private String password;

    @Value("${book.library.email.transport-protocol}")
    private String transportProtocol;
    @Value("${book.library.email.smtp-auth}")
    private String smtpAuth;
    @Value("${book.library.email.smtp-start-tls}")
    private String smtpStartTls;
    @Value("${book.library.email.debug}")
    private String debug;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(user);
        mailSender.setPassword(password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", transportProtocol);
        props.put("mail.smtp.auth", smtpAuth);
        props.put("mail.smtp.starttls.enable", smtpStartTls);
        props.put("mail.debug", debug);

        return mailSender;
    }

    @Bean
    public freemarker.template.Configuration getFreeMarkerConfig() {
        freemarker.template.Configuration configuration = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_28);
        configuration.setClassForTemplateLoading(this.getClass(), EmailConstants.BASE_PACKAGE_PATH);
        return configuration;
    }

}
