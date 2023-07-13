package de.pislaru.sergiu.booklibrary.email;

public final class EmailConstants {
    public final static String BASE_PACKAGE_PATH = "/templates";
    public final static String CONFIRM_REGISTRATION_PATH = "/confirm-registration?token=";

    public final static String EMAIL_CONFIRMATION_LINK_TEMPLATE = "registration-confirmation-email.flth";
    public final static String EMAIL_SECURITY_CODE_TEMPLATE = "security-code-email.flth";

    private EmailConstants(){
    }
}
