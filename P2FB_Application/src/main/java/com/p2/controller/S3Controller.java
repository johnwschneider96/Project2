package com.p2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.HttpMethod;
import com.p2.util.S3FileUtil;

/**
 * Controller method that controls file upload and download 
 * 
 * @author Barton Carson and John Schneider
 * @since 2019-9-13
 */
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class s3controller {
	
	/**
	 * autowired s3Util variable to create the signed Urls
	 */
	@Autowired
	private S3FileUtil s3Util;
	
	/**
	 * 
	 * @param fileName the name of the file being retrieved from the database
	 * @return the requested signed url
	 */
	@PutMapping("s3/{fileName}")
	public String createSignedPutUrl(@PathVariable String fileName) {
		// we would probably want a service layer where would go provide additional
		// logic to restrict who can get signed urls based off the filename
		return s3Util.createSignedUrl(fileName, HttpMethod.PUT);
	}

	/**
	 * 
	 * @param fileName the name of the file being retrieved from the database
	 * @return the requested signed url
	 */
	@GetMapping("s3/{fileName}")
	public String createSignedGetUrl(@PathVariable String fileName) {
		// we would probably want a service layer where would go provide additional
		// logic to restrict who can get signed urls based off the filename
		return s3Util.createSignedUrl(fileName, HttpMethod.GET);
	}

}
