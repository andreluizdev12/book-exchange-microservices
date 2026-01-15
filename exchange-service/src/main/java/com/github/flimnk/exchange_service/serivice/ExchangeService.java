package com.github.flimnk.exchange_service.serivice;


import com.github.flimnk.exchange_service.domain.exchange.Exchange;
import com.github.flimnk.exchange_service.domain.exchange.dto.ExchangeDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Service

public class ExchangeService {
    @Autowired
    private  ExchangeRepository exchangeRepository;

    @Autowired
    private  InstanceInformationService envariolmentService;

    public ExchangeDto getExchange(BigDecimal amount, String from , String to) {
       var exchange =  exchangeRepository.findByFromAndTo(from, to).
               orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Exchange does not exist "));
       var convertValue = amount.multiply(exchange.getConversionFactor());
       return new ExchangeDto(from, to , exchange.getConversionFactor(),convertValue,envariolmentService.retrieveServerPort());

    }

}
