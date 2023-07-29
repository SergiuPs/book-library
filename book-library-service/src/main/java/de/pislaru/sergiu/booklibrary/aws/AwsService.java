package de.pislaru.sergiu.booklibrary.aws;

public interface AwsService {
    String generatePresignedUrl(String fileName);
}
