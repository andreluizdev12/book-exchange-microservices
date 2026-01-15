package com.github.flimnk.book_service.integration.exchange;

import java.math.BigDecimal;

public record ExchangeDto(
         String from,
         String to,
         BigDecimal conversionFactor,
         BigDecimal convertedValue,
         String envirolment
){
    @Override
    public String toString() {
        return "ExchangeDto{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", conversionFactor=" + conversionFactor +
                ", convertedValue=" + convertedValue +
                ", envirolment='" + envirolment + '\'' +
                '}';
    }
}
