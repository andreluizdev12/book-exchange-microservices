package com.github.flimnk.exchange_service.controller;

import com.github.flimnk.exchange_service.domain.exchange.Exchange;
import com.github.flimnk.exchange_service.domain.exchange.dto.ExchangeDto;
import com.github.flimnk.exchange_service.serivice.ExchangeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Transient;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/exchange")
@Tag(name = "Exchange Endpoint")
public class ExchangeController {
    @Autowired
    private ExchangeService exchangeService;

    //http://localhost:8000/amount/from/to
    @Operation(summary = "Get an exchange from amount  of currency ")
    @GetMapping("/{amount}/{from}/{to}")
    public ExchangeDto getExchange(
            @PathVariable BigDecimal amount,
            @PathVariable String from,
            @PathVariable String to
    ){

       return  exchangeService.getExchange(amount, from ,to);

    }




}
