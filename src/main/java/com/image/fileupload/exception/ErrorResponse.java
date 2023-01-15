package com.image.fileupload.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MaxUploadSizeExceededException;


@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

	private int status;
	private String message;

	private ErrorResponse(String message, int status) {
		this.message = message;
		this.status = status;
	}

	public static ErrorResponse of(MaxUploadSizeExceededException maxUploadSizeExceededException) {
		return new ErrorResponse(maxUploadSizeExceededException.getMessage(),500);
	}

}
