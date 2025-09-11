package com.clarete.finance.core.domain;

import com.clarete.finance.dataprovider.mysql.entities.UserEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

public class Wallet {

    private BigDecimal balance = BigDecimal.ZERO;
    private UserEntity user;

    public Wallet(UserEntity user) {
        this.user = user;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public UserEntity getUser() {
        return user;
    }
}
