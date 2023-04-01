package org.example.controller;

import org.example.dto.request.BookRequest;
import org.example.dto.response.BookResponse;
import org.example.dto.response.GenericResponse;
import org.example.model.Book;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping
    public GenericResponse addBook(@RequestBody BookRequest bookRequest){
        return bookService.addBook(bookRequest);
    }

    @GetMapping
    public List<BookResponse> getAllBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping("/{id}")
    public Book getBook(@PathVariable String id){
        return bookService.getBook(id);
    }
    @PutMapping
    public GenericResponse updateBook(@RequestBody BookRequest bookRequest){
        return bookService.updateBook(bookRequest);
    }
    @PutMapping("/take/book")
    public GenericResponse takeBook(@RequestBody BookRequest bookRequest){
        return bookService.takeBook(bookRequest);
    }
    @PutMapping("/return/book")
    public GenericResponse returnBook(@RequestBody BookRequest bookRequest){
        return bookService.returnBook(bookRequest);
    }
    @DeleteMapping("/{id}")
    public GenericResponse deleteBook(@PathVariable String id){
        return bookService.deleteBook(id);
    }
    @DeleteMapping
    public GenericResponse deleteAllBooks(){
        return bookService.deleteAllBooks();
    }
}
