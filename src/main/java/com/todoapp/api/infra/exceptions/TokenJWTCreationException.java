package com.todoapp.api.infra.exceptions;

public class TokenJWTCreationException extends RuntimeException{
    public TokenJWTCreationException() {
        super("Erro na geração do Token JWT.");
    }
}
