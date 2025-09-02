package com.clarete.finance.mapper;

import com.clarete.finance.common.UserTypeEnum;
import com.clarete.finance.dataprovider.mysql.entities.UserEntity;
import com.clarete.finance.entrypoint.dto.UserRequestDTO;
import com.clarete.finance.entrypoint.dto.UserResponseDTO;
import org.apache.catalina.User;

public class UserMapper {

    public static UserResponseDTO userRequesttoUserResponse(UserRequestDTO user){
        UserResponseDTO userResponse = new UserResponseDTO(user.getName(), user.getCpfCnpj(), user.getEmail());
        return userResponse;
    }

    public static UserEntity userRequesttoEntity(UserRequestDTO user){
        UserTypeEnum type = UserTypeEnum.fromValue(user.getType());
        UserEntity userEntity = new UserEntity((user.getName()), user.getCpfCnpj(), user.getEmail(), user.getPassword(), type);
        return userEntity;
    }

}
