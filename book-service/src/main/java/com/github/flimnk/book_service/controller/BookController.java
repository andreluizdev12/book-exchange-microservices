package com.github.flimnk.book_service.controller;

import com.github.flimnk.book_service.domain.book.Book;
import com.github.flimnk.book_service.domain.book.dto.BookDto;
import com.github.flimnk.book_service.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/book")
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/{id}/{currency}")
    public BookDto getBook(@PathVariable Long id, @PathVariable String currency){
        return  bookService.getBook(id,currency);
    }
    @GetMapping
    public String hello(){
        return  "ola";
    }


}
