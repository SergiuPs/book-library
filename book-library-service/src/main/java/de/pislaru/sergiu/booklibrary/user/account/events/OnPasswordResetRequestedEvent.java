package de.pislaru.sergiu.booklibrary.user.account.events;

import de.pislaru.sergiu.booklibrary.model.user.User;
import org.springframework.context.ApplicationEvent;

public class OnPasswordResetRequestedEvent extends ApplicationEvent {

    private User user;
    private String applicationUrl;

    public OnPasswordResetRequestedEvent(User user, String applicationUrl) {
        super(user);
        this.user = user;
        this.applicationUrl = applicationUrl;
    }

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
    public String getApplicationUrl() {return applicationUrl;}
    public void setApplicationUrl(String applicationUrl) {this.applicationUrl = applicationUrl;}
}
