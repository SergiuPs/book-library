package de.pislaru.sergiu.booklibrary.payload.request;

import javax.validation.constraints.NotBlank;

public class SecurityCodeValidationRequest {

    @NotBlank
    private String code;

    public String getCode() {return code;}

}
