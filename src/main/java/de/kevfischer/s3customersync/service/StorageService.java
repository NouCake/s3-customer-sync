package de.kevfischer.s3customersync.service;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageService {

    private final static String DEFAULT_BUCKET = "customer-data";

    @Autowired private AmazonS3 s3Client;

    public void storeObject(String objectKey, String objectContent) {
        s3Client.putObject(
                DEFAULT_BUCKET,
                objectKey,
                objectContent
        );
    }

}
