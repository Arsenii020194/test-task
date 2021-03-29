package com.ammer.testtask.domain.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "USER_ACCOUNT", schema = "BANK")
public class UserAccount {
    private Long id;
    private User user;
    private Currency currency;
    private String name;
    private BigDecimal amount;

    @Id
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "ID_USER")
    public User getUser() {
        return user;
    }

    public void setUser(User idUser) {
        this.user = idUser;
    }

    @ManyToOne
    @JoinColumn(name = "ID_CURRENCY")
    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency idCurrency) {
        this.currency = idCurrency;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "AMOUNT", precision = 20, scale = 2)
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
        UserAccount that = (UserAccount) o;
        return Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(currency, that.currency) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, currency, name);
    }
}
