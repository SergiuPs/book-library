package de.pislaru.sergiu.booklibrary.aws;

import com.amazonaws.HttpMethod;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AwsServiceImpl implements AwsService {

    private static final Logger logger = LoggerFactory.getLogger(AwsServiceImpl.class);

    @Value("${book.library.aws.presigned-url-expires-after-ms}")
    private Long presignedUrlExpiresAfterMs;

    private final AmazonS3 s3Service;

    public AwsServiceImpl(AmazonS3 s3Service) {
        this.s3Service = s3Service;
    }

    @Override
    public String generatePresignedUrl(AwsBucket awsBucket, String fileName) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + presignedUrlExpiresAfterMs);

        String presignedUrl;
        try {
            presignedUrl = s3Service.generatePresignedUrl(awsBucket.getBucketName(), fileName, expirationDate, HttpMethod.PUT).toString();
        } catch (SdkClientException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
            throw new AwsException("Presigned URL could not be generated");
        }

        return presignedUrl;
    }
}
