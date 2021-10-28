package com.example.spring_demo_connect.controller;

import com.example.spring_demo_connect.model.Book;
import com.example.spring_demo_connect.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books/all")
    public List<Book> getAllBooks(){
        return bookService.retrieveListOfBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id){
        return bookService.retrieveBookById(id);
    }

    @PostMapping("/books")
    public String addBooks(@RequestBody List<Book> addBooks){
        return bookService.addBook(addBooks);
    }

    @PutMapping("/books")
    public String updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @DeleteMapping("/books/{id}")
    public String deleteBookById(@PathVariable int id){
        return bookService.deleteBook(id);
    }


    @PostMapping("/book")
    public ResponseEntity<String> addBook(@Valid @RequestBody Book book){
        return ResponseEntity.ok("User is valid");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValidException(final MethodArgumentNotValidException argumentNotValidException){
        Map<String, String> errors = new HashMap<>();
        argumentNotValidException.getBindingResult().getAllErrors().forEach(objectError -> {
            String field = ((FieldError)objectError).getField();
            String errorMessage = objectError.getDefaultMessage();
            errors.put(field, errorMessage);
        });
        return errors;
    }
}
