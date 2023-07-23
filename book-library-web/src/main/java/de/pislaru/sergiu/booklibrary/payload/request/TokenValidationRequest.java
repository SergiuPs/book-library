package de.pislaru.sergiu.booklibrary.payload.request;

import javax.validation.constraints.NotBlank;

public class TokenValidationRequest {

    @NotBlank
    private String token;

    public String getToken() {return token;}
}
