package com.example.demo.exception;

import com.example.demo.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 1️⃣ Resource not found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleNotFound(
            ResourceNotFoundException ex) {

        return new ResponseEntity<>(
                new ApiResponse(false, ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    // 2️⃣ Validation exception (CUSTOM)
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiResponse> handleValidation(
            ValidationException ex) {

        return new ResponseEntity<>(
                new ApiResponse(false, ex.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    // 3️⃣ Spring Security UsernameNotFoundException
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ApiResponse> handleUsernameNotFound(
            UsernameNotFoundException ex) {

        return new ResponseEntity<>(
                new ApiResponse(false, ex.getMessage()),
                HttpStatus.UNAUTHORIZED
        );
    }

    // 4️⃣ Bean validation (@Valid) failures
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleMethodValidation(
            MethodArgumentNotValidException ex) {

        String message = ex.getBindingResult()
                .getFieldError()
                .getDefaultMessage();

        return new ResponseEntity<>(
                new ApiResponse(false, message),
                HttpStatus.BAD_REQUEST
        );
    }

    // 5️⃣ Generic / JWT / Runtime exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGeneric(
            Exception ex) {

        return new ResponseEntity<>(
                new ApiResponse(false, ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
