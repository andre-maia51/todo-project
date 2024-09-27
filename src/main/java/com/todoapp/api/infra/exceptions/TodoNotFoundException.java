package com.todoapp.api.infra.exceptions;

public class TodoNotFoundException extends RuntimeException{
    public TodoNotFoundException() {
        super("O todo com o id informado não foi encontrado.");
    }
}
