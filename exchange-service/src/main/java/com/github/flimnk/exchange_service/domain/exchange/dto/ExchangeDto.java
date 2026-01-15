package com.github.flimnk.exchange_service.domain.exchange.dto;

import java.math.BigDecimal;

public record ExchangeDto(
         String from,
         String to,
         BigDecimal conversionFactor,
         BigDecimal convertedValue,
         String envirolment
){
}
