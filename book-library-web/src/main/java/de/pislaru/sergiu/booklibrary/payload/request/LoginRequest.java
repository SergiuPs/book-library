package de.pislaru.sergiu.booklibrary.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class LoginRequest {

    @NotBlank
    private String username;

    @NotEmpty
    private char[] password;

    public String getUsername() {return username;}
    public char[] getPassword() {return password;}
}
