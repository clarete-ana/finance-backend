package com.clarete.finance.core.domain;

import com.clarete.finance.common.UserTypeEnum;

public class User {

    private String name;
    private String cpfCnpj;
    private String email;
    private String password;
    private UserTypeEnum type;

    public User(String name, String document, String email, String password, int type) {
        this.name = name;
        this.cpfCnpj = document;
        this.email = email;
        this.password = password;
        this.type = UserTypeEnum.fromValue(type);
    }

    public String getName() {
        return name;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserTypeEnum getType() { return type; }
}
