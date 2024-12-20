package com.Ch1satooo.AgeOfCelebrities.utils;

import com.Ch1satooo.AgeOfCelebrities.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// @ControllerAdvice: Makes this class a global exception handler.
@ControllerAdvice
public class GlobalExceptionHandler {

    // @ExceptionHandler: Automatically match specific type of exception this method handles.
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Response<Void>> handleIllegalArgumentException(IllegalArgumentException e) {
        Response<Void> response = Response.newFailure(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // Handle other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<Void>> handleOtherException(Exception e) {
        Response<Void> response = Response.newFailure(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
