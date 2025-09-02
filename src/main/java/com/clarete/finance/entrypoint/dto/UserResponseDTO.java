package com.clarete.finance.entrypoint.dto;

public class UserResponseDTO {

    private String name;
    private String cpfCnpj;
    private String email;

    public UserResponseDTO(String name, String document, String email) {
        this.name = name;
        this.cpfCnpj = document;
        this.email = email;
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
}
