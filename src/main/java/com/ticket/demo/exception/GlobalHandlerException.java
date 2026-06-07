package com.ticket.demo.exception;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ticket.demo.model.payload.ApiResponse;

@RestControllerAdvice
public class GlobalHandlerException {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handlerMethodArgumentNotValidException(){
        ApiResponse apiResponse = new ApiResponse("Invalid format");
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(){
        ApiResponse apiResponse = new ApiResponse("The ticket with that id was not found");
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

}
