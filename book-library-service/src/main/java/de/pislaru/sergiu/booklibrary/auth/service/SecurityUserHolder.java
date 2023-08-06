package de.pislaru.sergiu.booklibrary.auth.service;

import de.pislaru.sergiu.booklibrary.auth.SecurityUser;

import java.util.Optional;

public interface SecurityUserHolder {

    SecurityUser getAuthenticatedUser();

    Long getIdOfTheAuthenticatedUser();

    String getEmailOfTheAuthenticatedUser();

}
