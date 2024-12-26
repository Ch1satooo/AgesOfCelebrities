package com.Ch1satooo.AgeOfCelebrities.utils;

import com.Ch1satooo.AgeOfCelebrities.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

// @ControllerAdvice: Makes this class a global exception handler.
@ControllerAdvice
public class GlobalExceptionHandler {

    // @ExceptionHandler: Automatically match specific type of exception this method handles.
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Response<Void>> handleIllegalArgumentException(IllegalArgumentException e) {
        Response<Void> response = Response.newFailure(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Response<Void>> handleIllegalStateException(IllegalStateException e) {
        Response<Void> response = Response.newFailure(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
