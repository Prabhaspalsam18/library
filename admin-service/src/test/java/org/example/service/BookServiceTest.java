package org.example.service;

import org.example.dto.request.BookRequest;
import org.example.dto.response.BookResponse;
import org.example.dto.response.GenericResponse;
import org.example.model.Book;
import org.example.model.BookDetails;
import org.example.repository.BookRepository;
import org.example.util.Constants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    void addBook() {
        BookRequest bookRequest = BookRequest.builder()
                .book_id("123")
                .book_details(BookDetails.builder()
                        .book_name("Rich")
                        .book_author("Ran")
                        .description("hdhgsghdhdgh")
                        .quantity(1000)
                        .build())
                .build();
        Book book = Book.builder()
                .book_id(bookRequest.getBook_id())
                .book_details(bookRequest.getBook_details())
                .build();
        GenericResponse result = bookService.addBook(bookRequest);
        Mockito.when(bookRepository.save(book)).thenReturn(book);
        Assertions.assertEquals(Constants.SUCCESS, result.getStatus());
        Assertions.assertEquals("Book Added Successfully", result.getDescription());

    }

    @Test
    void getAllBooks() {
        Book expectedBook1 = Book.builder()
                .book_id("123")
                .book_details(BookDetails.builder()
                        .book_name("Rich")
                        .book_author("Ran")
                        .description("hdhgsghdhdgh")
                        .quantity(1000)
                        .build())
                .build();
        Book expectedBook2 = Book.builder()
                .book_id("123")
                .book_details(BookDetails.builder()
                        .book_name("Rich")
                        .book_author("Ran")
                        .description("hdhgsghdhdgh")
                        .quantity(1000)
                        .build())
                .build();
        List<Book> bookResponses=new ArrayList<>();
        bookResponses.add(expectedBook1);
        bookResponses.add(expectedBook2);
        Mockito.when(bookRepository.findAll()).thenReturn(bookResponses);
        List<BookResponse> bookResponseList=bookService.getAllBooks();
        Assertions.assertEquals(2,bookResponseList.size());

    }

    @Test
    void getBook() {
        Book expectedBook1 = Book.builder()
                .book_id("123")
                .book_details(BookDetails.builder()
                        .book_name("Rich")
                        .book_author("Ran")
                        .description("hdhgsghdhdgh")
                        .quantity(1000)
                        .build())
                .build();
        String id="1";
        Mockito.when(bookRepository.findById(id)).thenReturn(Optional.of(expectedBook1));
        Book book=bookService.getBook(id);
        Assertions.assertEquals(expectedBook1,book);
    }

    @Test
    void updateBook() {
        BookRequest bookRequest = BookRequest.builder()
                .book_id("123")
                .book_details(BookDetails.builder()
                        .book_name("Rich")
                        .book_author("Ran")
                        .description("hdhgsghdhdgh")
                        .quantity(1000)
                        .build())
                .build();
        Book book = Book.builder()
                .book_id("123")
                .book_details(BookDetails.builder()
                        .book_name("Rich")
                        .book_author("Ran")
                        .description("hdhgsghdhdgh")
                        .quantity(1000)
                        .build())
                .build();
        Mockito.when(bookRepository.findById(bookRequest.getBook_id())).thenReturn(Optional.of(book));
        GenericResponse response=bookService.updateBook(bookRequest);
        Assertions.assertEquals(Constants.SUCCESS,response.getStatus());
        Assertions.assertEquals("Book updated successfully", response.getDescription());
    }

    @Test
    void deleteBook() {
        String id="1";
        Mockito.doNothing().when(bookRepository).deleteById(id);
        GenericResponse response=bookService.deleteBook(id);
        Assertions.assertEquals(Constants.SUCCESS,response.getStatus());
        Assertions.assertEquals("1 Book deleted Successfully", response.getDescription());
    }

    @Test
    void deleteAllBooks() {
        Mockito.doNothing().when(bookRepository).deleteAll();
        GenericResponse response=bookService.deleteAllBooks();
        Assertions.assertEquals(Constants.SUCCESS,response.getStatus());
        Assertions.assertEquals("All books deleted Successfully", response.getDescription());
    }

    @Test
    void takeBook() {
        BookRequest bookRequest = BookRequest.builder()
                .book_id("123")
                .book_details(BookDetails.builder()
                        .book_name("Rich")
                        .book_author("Ran")
                        .description("hdhgsghdhdgh")
                        .quantity(1000)
                        .build())
                .build();
        Book book = Book.builder()
                .book_id("123")
                .book_details(BookDetails.builder()
                        .book_name("Rich")
                        .book_author("Ran")
                        .description("hdhgsghdhdgh")
                        .quantity(1000)
                        .build())
                .build();
        Mockito.when(bookRepository.findById(bookRequest.getBook_id())).thenReturn(Optional.of(book));
        GenericResponse response=bookService.takeBook(bookRequest);
        Assertions.assertEquals(Constants.SUCCESS,response.getStatus());
        Assertions.assertEquals("Book taken successfully", response.getDescription());

    }

    @Test
    void returnBook() {
        BookRequest bookRequest = BookRequest.builder()
                .book_id("123")
                .book_details(BookDetails.builder()
                        .book_name("Rich")
                        .book_author("Ran")
                        .description("hdhgsghdhdgh")
                        .quantity(1000)
                        .build())
                .build();
        Book book = Book.builder()
                .book_id("123")
                .book_details(BookDetails.builder()
                        .book_name("Rich")
                        .book_author("Ran")
                        .description("hdhgsghdhdgh")
                        .quantity(1000)
                        .build())
                .build();
        Mockito.when(bookRepository.findById(bookRequest.getBook_id())).thenReturn(Optional.of(book));
        GenericResponse response=bookService.returnBook(bookRequest);
        Assertions.assertEquals(Constants.SUCCESS,response.getStatus());
        Assertions.assertEquals("Book returned successfully", response.getDescription());

    }
}