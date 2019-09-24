package com.p2.util;

import java.net.URL;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.amazonaws.HttpMethod;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;

/**
 * Controller method that controls file upload and download 
 * 
 * @author Barton Carson and John Schneider
 * @since 2019-9-13
 */
@Component
public class S3FileUtil implements InitializingBean {

	/**
	 * Name of the S3 Bucket
	 */
	private String bucketName = System.getenv("AWS_S3_BUCKET_NAME");

	/**
	 * S3 Bucket Access Key
	 */
	private String accessKey = System.getenv("AWS_ACCESS_KEY");

	/**
	 * S3 Bucket Secret Access Key
	 */
	private String secretAccessKey = System.getenv("AWS_SECRET_ACCESS_KEY");
	
	/**
	 * S3 Bucket Region
	 */
	private String region = System.getenv("AWS_SDK_REGION");

	/**
	 * S3 Credentials
	 */
	private BasicAWSCredentials awsCreds;
	
	/**
	 * S3 Client
	 */
	private AmazonS3 s3Client;

	/**
	 * 
	 * @param fileName the name of the file for creating the signed url
	 * @param method the method that is the presigned url is using
	 * @return the presigned url
	 */
	public String createSignedUrl(String fileName, HttpMethod method) {

		// Set the presigned URL to expire after one minute.
		java.util.Date expiration = new java.util.Date();
		long expTimeMillis = expiration.getTime();
		expTimeMillis += 1000 * 60;
		expiration.setTime(expTimeMillis);

		// Generate the presigned URL.
		GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, fileName)
				.withMethod(method).withExpiration(expiration);
		URL url = s3Client.generatePresignedUrl(generatePresignedUrlRequest);

		return url.toString();
	}

	/**
	 * Adds properties to the awsCreds and s3Client
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		awsCreds = new BasicAWSCredentials(accessKey, secretAccessKey);
		s3Client = AmazonS3ClientBuilder.standard().withRegion(region)
				.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
	}

}
