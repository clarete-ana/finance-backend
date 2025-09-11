package com.clarete.finance.entrypoint.controller;

import com.clarete.finance.core.domain.User;
import com.clarete.finance.core.service.UserService;
import com.clarete.finance.entrypoint.dto.UserRequestDTO;
import com.clarete.finance.entrypoint.dto.UserResponseDTO;
import com.clarete.finance.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/createAccount")
public class AccountController {

    @Autowired
    private UserService userService;

    @PostMapping
    private ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO user) throws Exception {
        User userDomain = UserMapper.userRequesttoDomain(user);
        User userCreated = userService.createUser(userDomain);
        return ResponseEntity.ok(UserMapper.domaintoResponse(userCreated));
    }
}
