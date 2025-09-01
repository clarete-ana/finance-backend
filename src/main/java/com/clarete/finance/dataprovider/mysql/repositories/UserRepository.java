package com.clarete.finance.dataprovider.mysql.repositories;

import com.clarete.finance.dataprovider.mysql.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
