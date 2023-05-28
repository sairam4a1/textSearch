package com.assignment.textsearchservice.utils;

import com.assignment.textsearchservice.exception.PostNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ApiResponse<String>> handleAllExceptions(Exception ex, WebRequest request) {
        ApiResponse<String> apiResponse = new ApiResponse<>(ex.getMessage(),
                request.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PostNotFoundException.class)
    public final ResponseEntity<ApiResponse<String>> handlePostNotFoundException(PostNotFoundException ex, WebRequest request) {
        ApiResponse<String> apiResponse = new ApiResponse<>(ex.getMessage(),
                request.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity handleValidationException(MethodArgumentNotValidException e, WebRequest request) {
        FieldError objectError = e.getBindingResult().getFieldError();
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).
                body(new ApiResponse<>(objectError.getDefaultMessage()));

    }
}
