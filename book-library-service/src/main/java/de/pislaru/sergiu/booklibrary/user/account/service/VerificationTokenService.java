package de.pislaru.sergiu.booklibrary.user.account.service;

import de.pislaru.sergiu.booklibrary.model.user.User;
import de.pislaru.sergiu.booklibrary.model.user.VerificationToken;

public interface VerificationTokenService {
    String createVerificationToken(User user);
    boolean isVerificationTokenValid(VerificationToken token);
    VerificationToken getTokenByString(String token);
}
