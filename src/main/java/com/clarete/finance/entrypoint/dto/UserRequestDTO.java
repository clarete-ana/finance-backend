package com.clarete.finance.entrypoint.dto;

import com.clarete.finance.common.UserTypeEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.apache.catalina.User;

public class UserRequestDTO {

    @NotBlank(message = "Nome é um campo obrigatório")
    private String name;

    @NotBlank(message = "Documento é um campo obrigatório")
    @Size(min = 11, max = 14, message = "Documento deve ter entre 11 e 14 caracteres")
    private String cpfCnpj;

    @Email(message = "Email deve ser válido")
    @NotBlank(message = "Email é um campo obrigatório")
    private String email;

    @NotBlank(message = "Senha é um campo obrigatório")
    @Size(min = 6, message = "Senha deve ter no minímo 6 caracteres")
    private String password;

    private Integer type;

    public UserRequestDTO() {
    }

    public UserRequestDTO(String name, String cpfCnpj, String email, String password, Integer type) {
        this.name = name;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.password = password;
        this.type = type;
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

    public Integer getType() {
        return type;
    }
}
