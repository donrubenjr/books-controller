package com.example.rest_controller.controller;

import com.example.rest_controller.exception.SecondException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalExceptionHandlerController {

    @GetMapping("/exception/resource")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void throwException(){
        throw new SecondException("throw exception: Second Exception");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SecondException.class)
    public Error errorHandlerException(final SecondException secondException){
        return new Error(secondException.getMessage());
    }

}
