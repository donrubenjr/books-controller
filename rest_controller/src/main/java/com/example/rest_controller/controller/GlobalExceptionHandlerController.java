package com.example.rest_controller.controller;

import com.example.rest_controller.exception.ItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<Object> handlerItemNotFoundException(ItemNotFoundException itemNotFoundException){
        return new ResponseEntity<>("Item not found", HttpStatus.NOT_FOUND);
    }
}
