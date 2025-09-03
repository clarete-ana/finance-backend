package com.clarete.finance.core.service;

import com.clarete.finance.common.UserTypeEnum;
import com.clarete.finance.core.domain.User;
import com.clarete.finance.dataprovider.mysql.entities.UserEntity;
import com.clarete.finance.dataprovider.mysql.repositories.UserRepository;
import com.clarete.finance.entrypoint.dto.UserRequestDTO;
import com.clarete.finance.entrypoint.dto.UserResponseDTO;
import com.clarete.finance.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AccountService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserRequestDTO user) throws Exception {
        if (Objects.nonNull(userRepository.findByEmail(user.getEmail())))
            throw new Exception("Já existe um usuário cadastrado com esse email!");

        if (Objects.nonNull(userRepository.findByCpfCnpj(user.getCpfCnpj())))
            throw new Exception("Já existe um usuário cadastrado com esse CPF/CNPJ!");

        User userDomain = UserMapper.userRequesttoDomain(user);

        UserEntity userEntity = UserMapper.userDomaintoEntity(userDomain);

        userRepository.save(userEntity);

        userDomain = UserMapper.userEntitytoDomain(userEntity);

        UserResponseDTO userResponse = UserMapper.domaintoResponse(userDomain);
        return userDomain;
    }
}
