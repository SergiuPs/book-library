package de.pislaru.sergiu.booklibrary.user.account.service;

public interface SecurityCodeService {
    String createSecurityCode(String email);
    boolean isSecurityCodeValid(String code, String email);
}
