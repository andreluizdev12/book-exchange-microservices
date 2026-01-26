package com.github.flimnk.book_service.integration.exchange;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExchangeAdapter {
    private final ExchangeProxy exchangeProxy;

    public  ExchangeAdapter(ExchangeProxy exchangeProxy) {
         this.exchangeProxy = exchangeProxy;
    }
    @CircuitBreaker(name = "exchange-circuit",fallbackMethod = "fallback")
    public ExchangeDto getExchange(Double price, String usd, String currency) {
        return  exchangeProxy.getExchange(price,"USD",currency);
    }
    public ExchangeDto fallback (Double price , String usd, String currency , Throwable throwable){
        return new ExchangeDto("USD" ,currency,1.0,price,"");
    }
}
