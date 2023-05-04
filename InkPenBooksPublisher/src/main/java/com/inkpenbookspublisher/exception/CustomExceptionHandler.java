package com.inkpenbookspublisher.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<?>authorNotFound(AuthorNotFoundException exception){
        ErrorResponse errorResponse = new ErrorResponse(false, "Author Not Found", exception.getMessage());
        return new ResponseEntity<>(errorResponse , HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<?>bookNotFound(BookNotFoundException exception){
        ErrorResponse errorResponse = new ErrorResponse(false, "Book Not Found", exception.getMessage());
        return new ResponseEntity<>(errorResponse , HttpStatus.BAD_REQUEST);
    }
}
