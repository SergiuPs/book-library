package de.pislaru.sergiu.booklibrary.payload.request;

import de.pislaru.sergiu.booklibrary.aws.AwsBucket;

import javax.validation.constraints.NotBlank;

public class PresignedUrlRequest {

    @NotBlank
    private String fileName;

    private AwsBucket awsBucket;

    public String getFileName() {return fileName;}
    public AwsBucket getBucket() {return awsBucket;}
}
