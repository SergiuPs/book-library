package de.pislaru.sergiu.booklibrary.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class EditEmailRequest {

    @NotBlank
    private String newEmail;

    @NotEmpty
    private char[] password;

    public String getNewEmail() {return newEmail;}
    public char[] getPassword() {return password;}
}
