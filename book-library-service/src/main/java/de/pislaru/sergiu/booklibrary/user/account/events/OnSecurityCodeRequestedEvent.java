package de.pislaru.sergiu.booklibrary.user.account.events;

import de.pislaru.sergiu.booklibrary.model.user.User;
import org.springframework.context.ApplicationEvent;

public class OnSecurityCodeRequestedEvent extends ApplicationEvent {

    private User user;

    public OnSecurityCodeRequestedEvent(User user) {
        super(user);
        this.user = user;
    }

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}
}
