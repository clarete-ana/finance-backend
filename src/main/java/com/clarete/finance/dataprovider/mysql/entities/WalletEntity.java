package com.clarete.finance.dataprovider.mysql.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "wallets")
public class WalletEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    public WalletEntity(UserEntity user) {
        this.user = user;
    }

    public WalletEntity() {
    }

    public Long getId() {
        return id;
    }


    public BigDecimal getBalance() {
        return balance;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
