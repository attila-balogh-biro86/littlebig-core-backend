package com.littlebig.services.gateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.littlebig.services.common.exception.ResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler({ResourceNotFoundException.class})
  public ResponseEntity<ErrorResponse> handleStudentNotFoundException(ResourceNotFoundException exception) {
    ErrorResponse response = ErrorResponse.builder(exception, ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,
            exception.getMessage())).build();
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
  }

  @ExceptionHandler({RuntimeException.class})
  public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException exception) {
    ErrorResponse response = ErrorResponse.builder(exception,
        ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,
        exception.getMessage())).build();
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
  }
}