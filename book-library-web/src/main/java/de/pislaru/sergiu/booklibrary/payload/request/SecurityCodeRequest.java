package de.pislaru.sergiu.booklibrary.payload.request;

import javax.validation.constraints.NotBlank;

public class SecurityCodeRequest {

    @NotBlank
    private String email;

    public String getEmail() {return email;}
}
