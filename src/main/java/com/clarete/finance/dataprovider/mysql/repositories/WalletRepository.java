package com.clarete.finance.dataprovider.mysql.repositories;

import com.clarete.finance.dataprovider.mysql.entities.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<WalletEntity, Long> {
}
