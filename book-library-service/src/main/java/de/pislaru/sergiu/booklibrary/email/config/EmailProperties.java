package de.pislaru.sergiu.booklibrary.email.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "book.library.email")
public class EmailProperties {

    private String host;
    private int port;
    private String user;
    private String password;

    private String transportProtocol;
    private String smtpAuth;
    private String smtpStartTls;
    private String debug;

    public String getHost() {return host;}
    public void setHost(String host) {this.host = host;}
    public int getPort() {return port;}
    public void setPort(int port) {this.port = port;}
    public String getUser() {return user;}
    public void setUser(String user) {this.user = user;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public String getTransportProtocol() {return transportProtocol;}
    public void setTransportProtocol(String transportProtocol) {this.transportProtocol = transportProtocol;}
    public String getSmtpAuth() {return smtpAuth;}
    public void setSmtpAuth(String smtpAuth) {this.smtpAuth = smtpAuth;}
    public String getSmtpStartTls() {return smtpStartTls;}
    public void setSmtpStartTls(String smtpStartTls) {this.smtpStartTls = smtpStartTls;}
    public String getDebug() {return debug;}
    public void setDebug(String debug) {this.debug = debug;}
}
