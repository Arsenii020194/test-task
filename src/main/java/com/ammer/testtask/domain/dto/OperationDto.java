package com.ammer.testtask.domain.dto;

import com.ammer.testtask.domain.list.OperationType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class OperationDto {
    private Long id;
    private OperationType type;
    private String from;
    private String to;
    private LocalDate date;
    private BigDecimal amount;
}
