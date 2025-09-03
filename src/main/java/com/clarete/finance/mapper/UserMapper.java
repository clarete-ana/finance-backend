package com.clarete.finance.mapper;

import com.clarete.finance.common.UserTypeEnum;
import com.clarete.finance.core.domain.User;
import com.clarete.finance.dataprovider.mysql.entities.UserEntity;
import com.clarete.finance.entrypoint.dto.UserRequestDTO;
import com.clarete.finance.entrypoint.dto.UserResponseDTO;

public class UserMapper {

    public static User userRequesttoDomain(UserRequestDTO user){
        UserTypeEnum type = UserTypeEnum.fromValue(user.getType());
        User userDomain = new User((user.getName()), user.getCpfCnpj(), user.getEmail(), user.getPassword(), type.getValor());
        return userDomain;
    }
    public static UserEntity userDomaintoEntity(User user){
        UserEntity userEntity = new UserEntity((user.getName()), user.getCpfCnpj(), user.getEmail(), user.getPassword(), user.getType().getValor());
        return userEntity;
    }

    public static User userEntitytoDomain(UserEntity user){
        User userDomain = new User(user.getName(), user.getCpfCnpj(), user.getEmail(), user.getPassword(), user.getType().getValor());
        return userDomain;
    }

    public static UserResponseDTO domaintoResponse(User user){
        UserResponseDTO userResponse = new UserResponseDTO(user.getName(), user.getCpfCnpj(), user.getEmail());
        return userResponse;
    }


}
