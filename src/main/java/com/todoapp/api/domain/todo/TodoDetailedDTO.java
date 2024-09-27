package com.todoapp.api.domain.todo;

public record TodoDetailedDTO(Long id, String title, String description) {
    public TodoDetailedDTO(Todo data) {
        this(data.getId(), data.getTitle(), data.getDescription());
    }
}
