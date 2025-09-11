package com.clarete.finance.dataprovider.mysql.repositories;

import com.clarete.finance.dataprovider.mysql.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity,Long> {

}
