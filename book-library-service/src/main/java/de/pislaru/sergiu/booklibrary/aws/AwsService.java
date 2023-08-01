package de.pislaru.sergiu.booklibrary.aws;

public interface AwsService {
    String generatePresignedUrl(AwsBucket awsBucket, String fileName);
}
