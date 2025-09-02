package com.clarete.finance.common;

import org.apache.catalina.User;

public enum UserTypeEnum {
    COMMON(1),
    MERCHANT(2);

    private int valor;

    UserTypeEnum(int valor){
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static UserTypeEnum fromValue(int valor){
        for (UserTypeEnum type : values()){
            if(type.getValor() == valor){
                return type;
            }
        }
        throw new IllegalArgumentException("Tipo de usuário inválido: " + valor);
    }
}
