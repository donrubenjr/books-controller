package com.example.rest_controller.service;

import com.example.rest_controller.model.Book;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookService {

    private static Map<Integer, Book> bookMap = new HashMap<>();

    static {
        Book book = new Book();
        book.setId(1);
        book.setBookTitle("RestAPI");
        book.setBookAuthor("Ruben");
        book.setDatePublished(LocalDate.of(2020, Month.JANUARY, 10));
        bookMap.put(book.getId(), book);

        Book book2 = new Book();
        book2.setId(1);
        book2.setBookTitle("Basta Amorato Ato Sabot");
        book2.setBookAuthor("Luv");
        book2.setDatePublished(LocalDate.of(2020, Month.FEBRUARY, 14));
        bookMap.put(book2.getId(), book2);
    }

    public List<Book> retrieveAllBooks(){
        return bookMap.values().stream().collect(Collectors.toList());
    }

    public Book retrieveProductById(int id){
        return bookMap.get(id);
    }

    public Book addNewBook(Book newBook){
        Book book = new Book();
        book.setBookTitle(newBook.getBookTitle());
        book.setBookAuthor(newBook.getBookAuthor());
        book.setDatePublished(newBook.getDatePublished());
        bookMap.put(book.getId(), book);
        return book;
    }

    public Book updateBookByDate(int id, LocalDate newDate){
        Book book = null;
        if (bookMap.containsKey(id)){
            book = bookMap.get(id);
            book.setDatePublished(newDate);
        }
        return book;
    }

    public void deleteBookById(int id){
        if (bookMap.containsKey(id)){
            bookMap.remove(id);
        }
    }

}
