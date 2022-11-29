package de.kevfischer.s3customersync.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Config {

    @Value("#{environment.S3_KEY}")
    private String s3Key;
    @Value("#{environment.S3_SECRET}")
    private String s3Secret;

    @Bean
    public AmazonS3 s3Client()  {
        var builder = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials(
                                s3Key,
                                s3Secret
                        )
                ));

        builder.setEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(
                "s3-eu-central-1.ionoscloud.com",
                "s3-eu-central-1"
        ));

        return builder.build();
    }

}
