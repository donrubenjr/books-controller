package com.example.rest_controller.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class Book {
    private int id;
    private String bookTitle;
    private String bookAuthor;
    private LocalDate datePublished;
}
