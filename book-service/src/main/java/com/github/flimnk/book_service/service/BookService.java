package com.github.flimnk.book_service.service;

import com.github.flimnk.book_service.domain.book.dto.BookDto;
import com.github.flimnk.book_service.integration.exchange.ExchangeProxy;
import com.github.flimnk.book_service.repo.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private InstanceInformationService serverPort;

    @Autowired
    private ExchangeProxy exchangeProxy;


    public BookDto getBook(Long id  , String currency){
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Book does with id: " +id+ "not exists "));


        var exchage  = exchangeProxy.getExchange(book.getPrice(),"USD",currency);
        String templatePort = "Book-Port: " + serverPort.retrieveServerPort() + "////" +"Exchange-Port: " + exchage.envirolment();
        var dto = new BookDto(book.getAuthor(), book.getTitle(),book.getLaunchDate(),exchage.convertedValue() ,currency, templatePort);
        return  dto;
    }
}
