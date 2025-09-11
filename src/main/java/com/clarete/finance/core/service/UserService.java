package com.clarete.finance.core.service;

import com.clarete.finance.core.domain.User;
import com.clarete.finance.dataprovider.mysql.entities.UserEntity;
import com.clarete.finance.dataprovider.mysql.entities.WalletEntity;
import com.clarete.finance.dataprovider.mysql.repositories.UserRepository;
import com.clarete.finance.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WalletService walletService;

    public User createUser(User user) throws Exception {
        if (Objects.nonNull(userRepository.findByEmail(user.getEmail())))
            throw new Exception("Já existe um usuário cadastrado com esse email!");

        if (Objects.nonNull(userRepository.findByCpfCnpj(user.getCpfCnpj())))
            throw new Exception("Já existe um usuário cadastrado com esse CPF/CNPJ!");

        UserEntity userEntity = UserMapper.userDomaintoEntity(user);

        userEntity = userRepository.save(userEntity);

        User userCreated = UserMapper.userEntitytoDomain(userEntity);

        walletService.createWallet(userEntity);

        return userCreated;
    }
}
