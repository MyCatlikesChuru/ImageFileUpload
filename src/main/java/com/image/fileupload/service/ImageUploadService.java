package com.image.fileupload.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageUploadService {

	String StoreImage(MultipartFile img, AwsS3Path awsS3Path);

}
