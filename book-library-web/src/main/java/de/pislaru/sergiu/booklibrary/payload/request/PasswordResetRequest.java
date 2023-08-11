package de.pislaru.sergiu.booklibrary.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class PasswordResetRequest {

    @NotBlank
    private String token;

    @NotEmpty
    private char[] newPassword;

    public String getToken() {return token;}
    public char[] getNewPassword() {return newPassword;}
}
