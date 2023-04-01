package org.example.controller;

import org.example.dto.request.BookRequest;
import org.example.dto.response.BookResponse;
import org.example.dto.response.GenericResponse;
import org.example.model.Book;
import org.example.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
@SpringBootTest
class BookControllerTest {
    @InjectMocks
    BookController bookController;

    @Mock
    BookService bookService;
    @Test
    void addBook() {
        BookRequest bookRequest= Mockito.mock(BookRequest.class);
        GenericResponse mockGenericResponse=Mockito.mock(GenericResponse.class);
        Mockito.when(bookService.addBook(bookRequest)).thenReturn(mockGenericResponse);
       GenericResponse genericResponse=bookController.addBook(bookRequest);
        Assertions.assertEquals(mockGenericResponse,genericResponse);
    }

  @Test
    void getAllBooks() {
        List<BookResponse> bookResponses=new ArrayList<>();
       bookResponses.add(Mockito.mock(BookResponse.class));
       bookResponses.add(Mockito.mock(BookResponse.class));
        Mockito.when(bookService.getAllBooks()).thenReturn(bookResponses);
        List<BookResponse> bookResponseList=bookController.getAllBooks();
        Assertions.assertEquals(2,bookResponseList.size());
    }

    @Test
    void getBook() {
        Book mockResponse=Mockito.mock(Book.class);
        String id="1";
        Mockito.when(bookService.getBook(id)).thenReturn(mockResponse);
        Book book=bookController.getBook(id);
        Assertions.assertEquals(mockResponse,book);
    }

    @Test
    void updateBook() {

        BookRequest bookRequest= Mockito.mock(BookRequest.class);
        GenericResponse genericResponses=Mockito.mock(GenericResponse.class);
        Mockito.when(bookService.updateBook(bookRequest)).thenReturn(genericResponses);
        GenericResponse genericResponse=bookController.updateBook(bookRequest);
        Assertions.assertEquals(genericResponses,genericResponse);
    }

    @Test
    void takeBook() {
        BookRequest bookRequest= Mockito.mock(BookRequest.class);
        GenericResponse genericResponses=Mockito.mock(GenericResponse.class);
        Mockito.when(bookService.takeBook(bookRequest)).thenReturn(genericResponses);
        GenericResponse genericResponse=bookController.takeBook(bookRequest);
        Assertions.assertEquals(genericResponses,genericResponse);
    }

    @Test
    void returnBook() {
        BookRequest bookRequest= Mockito.mock(BookRequest.class);
        GenericResponse genericResponses=Mockito.mock(GenericResponse.class);
        Mockito.when(bookService.returnBook(bookRequest)).thenReturn(genericResponses);
        GenericResponse genericResponse=bookController.returnBook(bookRequest);
        Assertions.assertEquals(genericResponses,genericResponse);
    }

    @Test
    void deleteBook() {
        GenericResponse genericResponses=Mockito.mock(GenericResponse.class);
        String id="1";
        Mockito.when(bookService.deleteBook(id)).thenReturn(genericResponses);
        GenericResponse genericResponse=bookController.deleteBook(id);
        Assertions.assertEquals(genericResponses,genericResponse);
    }

    @Test
    void deleteAllBooks() {
        GenericResponse genericResponses=Mockito.mock(GenericResponse.class);
        Mockito.when(bookService.deleteAllBooks()).thenReturn(genericResponses);
        GenericResponse genericResponse=bookController.deleteAllBooks();
        Assertions.assertEquals(genericResponses,genericResponse);
    }
}