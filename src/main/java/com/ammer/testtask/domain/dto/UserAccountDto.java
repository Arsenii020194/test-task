package com.ammer.testtask.domain.dto;

import com.ammer.testtask.domain.list.Currency;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserAccountDto {
    private Long id;
    private Long user;
    private Currency currency;
    private String name;
    private BigDecimal amount;
}
