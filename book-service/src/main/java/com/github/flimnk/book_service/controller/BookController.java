package com.github.flimnk.book_service.controller;

import com.github.flimnk.book_service.controller.dto.BookDto;
import com.github.flimnk.book_service.service.BookService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.GET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//O serviço NÃO deve conhecer o path público
//
//Quem define o path público é o API Gateway
@RequestMapping("/book")
@Tag(name = "Book Endpoint")
@RestController
public class BookController {
    @Autowired
    private BookService bookService;
     Integer count = 0;
    @Operation(summary = "Find a specific book by your idG")
        @GetMapping("/{id}/{currency}")
    public BookDto getBook(@PathVariable Long id, @PathVariable String currency){
        return  bookService.getBook(id,currency);
    }

    @RateLimiter(name ="rate-teste",fallbackMethod = "fallback")
    @GetMapping()
    public String hello(){
        count++;
        return  "tentativa: " + count;

    }

    public String fallback (Throwable throwable) {
        return "fallback";
    }

}
