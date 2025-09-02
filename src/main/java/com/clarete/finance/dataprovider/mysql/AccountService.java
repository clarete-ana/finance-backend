package com.clarete.finance.dataprovider.mysql;

import com.clarete.finance.common.UserTypeEnum;
import com.clarete.finance.dataprovider.mysql.entities.UserEntity;
import com.clarete.finance.dataprovider.mysql.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AccountService {

    @Autowired
    private UserRepository userRepository;

    public Long createUser(UserEntity user) throws Exception {
        if (Objects.nonNull(userRepository.findByEmail(user.getEmail())))
            throw new Exception("Já existe um usuário cadastrado com esse email!");

        if (Objects.nonNull(userRepository.findByCpfCnpj(user.getCpfCnpj())))
            throw new Exception("Já existe um usuário cadastrado com esse CPF/CNPJ!");

        Long idUser = userRepository.save(user).getId();
        return idUser;
    }
}
