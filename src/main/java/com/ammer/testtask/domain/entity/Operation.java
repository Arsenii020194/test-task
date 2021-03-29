package com.ammer.testtask.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "OPERATION", schema = "BANK")
public class Operation {
    private Long id;
    private OperationType type;
    private Long from;
    private Long to;
    private LocalDate date;
    private BigDecimal amount;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "ID_TYPE")
    public OperationType getType() {
        return type;
    }

    public void setType(OperationType idType) {
        this.type = idType;
    }

    @Column(name = "ID_FROM")
    public Long getFrom() {
        return from;
    }

    public void setFrom(Long idFrom) {
        this.from = idFrom;
    }

    @Column(name = "ID_TO")
    public Long getTo() {
        return to;
    }

    public void setTo(Long idTo) {
        this.to = idTo;
    }

    @Column(name = "DATE")
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Column(name = "AMOUNT")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return Objects.equals(id, operation.id) && Objects.equals(type, operation.type) && Objects.equals(from, operation.from) && Objects.equals(to, operation.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, from, to);
    }
}
