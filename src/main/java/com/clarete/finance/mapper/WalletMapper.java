package com.clarete.finance.mapper;

import com.clarete.finance.core.domain.Wallet;
import com.clarete.finance.dataprovider.mysql.entities.WalletEntity;

public class WalletMapper {

    public static Wallet Wallet (WalletEntity walletEntity){
        Wallet walletDomain = new Wallet(walletEntity.getUser());
        return walletDomain;
    }

    public static WalletEntity WalletEntity(Wallet wallet){
        WalletEntity walletEntity = new WalletEntity(wallet.getUser());
        return walletEntity;
    }
}
