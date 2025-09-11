package com.clarete.finance.core.service;

import com.clarete.finance.core.domain.User;
import com.clarete.finance.core.domain.Wallet;
import com.clarete.finance.dataprovider.mysql.entities.UserEntity;
import com.clarete.finance.dataprovider.mysql.entities.WalletEntity;
import com.clarete.finance.dataprovider.mysql.repositories.WalletRepository;
import com.clarete.finance.mapper.UserMapper;
import com.clarete.finance.mapper.WalletMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {


    @Autowired
    WalletRepository walletRepository;

    public Wallet createWallet(UserEntity user){

        WalletEntity walletEntity = new WalletEntity(user);
        walletEntity = walletRepository.save(walletEntity);
        Wallet walletCreated = WalletMapper.Wallet(walletEntity);
        return walletCreated;
    }


}
