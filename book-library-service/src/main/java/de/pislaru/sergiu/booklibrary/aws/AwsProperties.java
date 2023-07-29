package de.pislaru.sergiu.booklibrary.aws;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "book.library.aws")
public class AwsProperties {

    private String accessKey;
    private String secretKey;
    private String s3RegionName;
    private String s3BucketName;
    private Long presignedUrlExpiresAfterMs;

    public String getAccessKey() {return accessKey;}
    public void setAccessKey(String accessKey) {this.accessKey = accessKey;}
    public String getSecretKey() {return secretKey;}
    public void setSecretKey(String secretKey) {this.secretKey = secretKey;}
    public String getS3RegionName() {return s3RegionName;}
    public void setS3RegionName(String s3RegionName) {this.s3RegionName = s3RegionName;}
    public String getS3BucketName() {return s3BucketName;}
    public void setS3BucketName(String s3BucketName) {this.s3BucketName = s3BucketName;}
    public Long getPresignedUrlExpiresAfterMs() {return presignedUrlExpiresAfterMs;}
    public void setPresignedUrlExpiresAfterMs(Long presignedUrlExpiresAfterMs) {this.presignedUrlExpiresAfterMs = presignedUrlExpiresAfterMs;}
}
