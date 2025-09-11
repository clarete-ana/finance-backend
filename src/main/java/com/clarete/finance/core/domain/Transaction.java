package com.clarete.finance.core.domain;

import java.math.BigDecimal;

public class Transaction {

    private String cpfCnpjOrigin;

    private String cpfCnpjDestiny;

    private BigDecimal amount;

    public Transaction(String cpfCnpjOrigin, String cpfCnpjDestiny, BigDecimal amount) {
        this.cpfCnpjOrigin = cpfCnpjOrigin;
        this.cpfCnpjDestiny = cpfCnpjDestiny;
        this.amount = amount;
    }

    public String getCpfCnpjOrigin() {
        return cpfCnpjOrigin;
    }

    public String getCpfCnpjDestiny() {
        return cpfCnpjDestiny;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
