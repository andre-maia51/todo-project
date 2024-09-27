package com.todoapp.api.infra.exceptions;

public class TokenJWTVerificationException extends RuntimeException{
    public TokenJWTVerificationException() {
        super("Erro na verificação do token JWT.");
    }
}
