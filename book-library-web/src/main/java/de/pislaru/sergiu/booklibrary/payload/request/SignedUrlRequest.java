package de.pislaru.sergiu.booklibrary.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class SignedUrlRequest {

    @Positive
    private Long userId;
    @NotBlank
    private String fileName;

    public Long getUserId() {return userId;}
    public String getFileName() {return fileName;}
}
