package com.github.flimnk.book_service.controller.dto;

import java.math.BigDecimal;
import java.util.Date;

public record BookDto(
        String author,
        String title,
        Date launchDate,
        Double price,
        String currency,
        String environment
) {
}
