package com.clarete.finance.dataprovider.mysql.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "origin_wallet_id", nullable = false)
    private WalletEntity originWallet;

    @ManyToOne
    @JoinColumn(name = "destiny_wallet_id", nullable = false)
    private WalletEntity destinyWallet;

    @Column(name = "value")
    private BigDecimal value;

    private LocalDateTime date;

    public TransactionEntity() {
    }

    public TransactionEntity(WalletEntity originWallet, WalletEntity destinyWallet, BigDecimal value) {
        this.originWallet = originWallet;
        this.destinyWallet = destinyWallet;
        this.value = value;
        this.date = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public WalletEntity getOriginWallet() {
        return originWallet;
    }

    public void setOriginWallet(WalletEntity originWallet) {
        this.originWallet = originWallet;
    }

    public WalletEntity getDestinyWallet() {
        return destinyWallet;
    }

    public void setDestinyWallet(WalletEntity destinyWallet) {
        this.destinyWallet = destinyWallet;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
