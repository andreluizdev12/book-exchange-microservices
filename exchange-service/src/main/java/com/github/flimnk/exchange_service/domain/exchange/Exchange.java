package com.github.flimnk.exchange_service.domain.exchange;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Entity


public class Exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  id ;

    @Column(name = "from_currency",nullable = false,length = 3)
    private String from;

    @Column(name = "to_currency",nullable = false,length = 3)
    private String to;

    @Column(name = "conversion_factor",nullable = false)
    private BigDecimal conversionFactor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(BigDecimal conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exchange exchange = (Exchange) o;
        return Objects.equals(id, exchange.id) && Objects.equals(from, exchange.from) && Objects.equals(to, exchange.to) && Objects.equals(conversionFactor, exchange.conversionFactor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, to, conversionFactor);
    }
}
