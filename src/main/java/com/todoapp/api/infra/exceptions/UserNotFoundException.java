package com.todoapp.api.infra.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("O usuário não existe ou não foi encontrado.");
    }
}
