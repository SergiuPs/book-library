package de.pislaru.sergiu.booklibrary.aws;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum AwsBucket {

    @JsonProperty("user-avatar")
    USER_AVATAR("spring-library-user-avatars");

    private final String bucketName;

    AwsBucket(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
