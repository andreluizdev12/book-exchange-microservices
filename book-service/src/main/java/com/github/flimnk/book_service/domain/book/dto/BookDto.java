package com.github.flimnk.book_service.domain.book.dto;

import java.math.BigDecimal;
import java.util.Date;

public record BookDto(
        String author,
        String title,
        Date launchDate,
        BigDecimal price,
        String currency,
        String environment
) {
}
