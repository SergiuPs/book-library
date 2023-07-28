package de.pislaru.sergiu.booklibrary.aws;

public interface AwsService {
    String generateSignedUrl(Long userId, String fileName);
}
