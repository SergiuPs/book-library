package de.pislaru.sergiu.booklibrary.aws;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfig {

    @Value("${book.library.aws.access-key}")
    private String accessKey;

    @Value("${book.library.aws.secret-key}")
    private String secretKey;

    @Value("${book.library.aws.s3-region-name}")
    private String s3RegionName;

    @Bean
    public AmazonS3 s3Client() {
        final BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(s3RegionName)
                .build();
    }
}
