package com.example.rest_controller.controller;


import com.example.rest_controller.exception.ItemNotFoundException;
import com.example.rest_controller.exception.SecondException;
import com.example.rest_controller.model.Book;
import com.example.rest_controller.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/books")
public class BookController {
    BookService bookService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Book> getAllBooks(){
        return new ArrayList<>();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable int id){
        return new Book();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Book> updateBookById(@PathVariable int id){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Book> deleteBookById(@PathVariable int id){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/testException")
    public void getTestException(){
        throw new ItemNotFoundException();
    }

    @GetMapping("/testExceptionError")
    public void getTestErrorException(){
        throw new SecondException("From Local Controller");
    }

}
