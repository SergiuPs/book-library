package de.pislaru.sergiu.booklibrary.email;

public final class EmailConstants {
    public final static String BASE_PACKAGE_PATH = "/templates";
    public final static String CONFIRM_REGISTRATION_PATH = "/registration-confirmation?token=";
    public final static String PASSWORD_RESET_PATH = "/password-reset?token=";

    public final static String CONFIRMATION_LINK_TEMPLATE = "registration-confirmation-email.flth";
    public final static String SECURITY_CODE_TEMPLATE = "security-code-email.flth";
    public final static String PASSWORD_RESET_TEMPLATE = "password-reset-email.flth";

    private EmailConstants(){
    }
}
