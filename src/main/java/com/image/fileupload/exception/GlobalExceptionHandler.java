package com.image.fileupload.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(MaxUploadSizeExceededException e) {
        log.error("MaxUploadSizeExceededException", e);

        log.info("# 예외처리 잡음");
        final ErrorResponse response = ErrorResponse.of(e);
        return ResponseEntity.internalServerError().body(response);
    }
}
