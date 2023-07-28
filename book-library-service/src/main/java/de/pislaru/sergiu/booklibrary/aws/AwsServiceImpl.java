package de.pislaru.sergiu.booklibrary.aws;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class AwsServiceImpl implements AwsService {

    @Value("${book.library.aws.s3-bucket-name}")
    private String s3BucketName;

    @Value("${book.library.aws.signed-url-expires-after-ms}")
    private Long signedUrlExpiresAfterMs;

    private final AmazonS3 s3Service;

    public AwsServiceImpl(AmazonS3 s3Service) {
        this.s3Service = s3Service;
    }

    @Override
    public String generateSignedUrl(Long userId, String fileName) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + signedUrlExpiresAfterMs);

        return s3Service.generatePresignedUrl(s3BucketName, fileName, expirationDate, HttpMethod.PUT).toString();
    }
}
