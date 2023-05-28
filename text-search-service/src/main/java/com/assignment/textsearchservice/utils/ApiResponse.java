package com.assignment.textsearchservice.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
	private LocalDateTime timestamp;
	private String message;
	private T data;
	private int httpCode;

	public ApiResponse(String defaultMessage) {
		this.message = defaultMessage;
		this.timestamp = LocalDateTime.now();
		this.httpCode = HttpStatus.BAD_REQUEST.value();
	}
	public ApiResponse(String message, T data, int httpCode) {
		this.message = message;
		this.timestamp = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
		this.httpCode = httpCode;
		this.data = data;
	}

}
