package com.tushar.skillswap.common.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "Standard error response")
public class ErrorResponse {

	@Schema(example = "VALIDATION_ERROR")
	private String errorCode;
	
	@Schema(example = "email must not be blank")
	private String message;
	
	@Schema(example = "2026-01-12T18:30:00")
	private LocalDateTime timestamp;
	
	public ErrorResponse(String errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
		this.timestamp = LocalDateTime.now();
	}
}
