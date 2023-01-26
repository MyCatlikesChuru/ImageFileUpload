package com.image.fileupload.controller;

import com.image.fileupload.service.AwsS3Path;
import com.image.fileupload.service.AwsS3Service;
import com.image.fileupload.service.ImageUploadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {
    private final ImageUploadService awsS3Service;

    public UploadController(AwsS3Service awsS3Service) {
        this.awsS3Service = awsS3Service;
    }

    /*
     * AWS 엔드포인트 폴더에 저장
     * */
    @PostMapping("/main")
    public String saveImageMain(@RequestParam MultipartFile file){

        log.info("multipartFile = {}", file);
        String url = awsS3Service.StoreImage(file, AwsS3Path.MAIN);
        log.info("url = {}",url);
        return url;
    }

    /*
    * AWS 엔드포인트내 articles 폴더에 저장
    * */
    @PostMapping("/articles")
    public String saveImageArticles(@RequestParam MultipartFile file){

        log.info("multipartFile = {}", file);
        String url = awsS3Service.StoreImage(file, AwsS3Path.ARTICLES);
        log.info("url = {}",url);
        return url;
    }
}
