package com.example.payment.application.core.domain;

import java.math.BigDecimal;

public class User {
    private Integer id;

    private String name;

    private BigDecimal balance;

    public User() {
    }

    public User(Integer id, String name, BigDecimal balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void debitBalance(final BigDecimal value) {
        this.balance.subtract(value);
    }
}
