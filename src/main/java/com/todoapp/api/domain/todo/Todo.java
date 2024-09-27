package com.todoapp.api.domain.todo;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Todo")
@Table(name = "todos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Todo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Boolean active;

    public Todo(TodoDTO data) {
        this.title = data.title();
        this.description = data.description();
        this.active = true;
    }

    public void updateTodoInfo(TodoDTO data) {
        this.title = data.title();
        this.description = data.description();
    }

    public void deleteTodo() {
        this.active = false;
    }
}
