package de.pislaru.sergiu.booklibrary.payload.request;

import javax.validation.constraints.NotBlank;

public class SecurityCodeValidationRequest {

    @NotBlank
    private String code;

    @NotBlank
    private String email;

    public String getCode() {return code;}
    public String getEmail() {return email;}
}
