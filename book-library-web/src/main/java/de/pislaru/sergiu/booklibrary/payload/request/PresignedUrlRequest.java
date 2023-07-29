package de.pislaru.sergiu.booklibrary.payload.request;

import javax.validation.constraints.NotBlank;

public class PresignedUrlRequest {

    @NotBlank
    private String fileName;

    public String getFileName() {return fileName;}
}
