package com.clarete.finance.core.service;

import com.clarete.finance.common.UserTypeEnum;
import com.clarete.finance.core.domain.Transaction;
import com.clarete.finance.dataprovider.mysql.entities.TransactionEntity;
import com.clarete.finance.dataprovider.mysql.entities.WalletEntity;
import com.clarete.finance.dataprovider.mysql.repositories.TransactionRepository;
import com.clarete.finance.dataprovider.mysql.repositories.WalletRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Transactional
    public void makeTransfer(Transaction transaction) throws Exception {

        WalletEntity originWallet = getWallet(transaction.getCpfCnpjOrigin());
        WalletEntity destinyWallet = getWallet(transaction.getCpfCnpjDestiny());

        if(originWallet.getUser().getType().equals(UserTypeEnum.MERCHANT)){
            throw new Exception("Usuários lojistas não podem realizar transferências!");
        }
        if((originWallet.getBalance().compareTo(transaction.getAmount()) < 0)){
            throw new Exception("Saldo insuficiente para essa transferência");
        }

        originWallet.setBalance( originWallet.getBalance().subtract(transaction.getAmount()));
        destinyWallet.setBalance(destinyWallet.getBalance().add(transaction.getAmount()));

        walletRepository.save(originWallet);
        walletRepository.save(destinyWallet);

        TransactionEntity newTransaction = new TransactionEntity(originWallet, destinyWallet, transaction.getAmount());
        transactionRepository.save(newTransaction);
    }

    private WalletEntity getWallet(String cpfCnpj) throws Exception {
        return walletRepository.findByUserCpfCnpj(cpfCnpj).orElseThrow(()-> new Exception("Carteira não encontrada"));

    }
}
