package com.image.fileupload.service;

import lombok.Getter;

/*
* AwsS3 내 폴더로 나눠서 저장할경우
* */
public enum AwsS3Path {
    MAIN(""),
    SHOWS("/shows"),
    ARTICLES("/articles"),
    PROFILEIMAGE("/profileimage");

    @Getter
    private String path;

    AwsS3Path(String path) {
        this.path = path;
    }

}
