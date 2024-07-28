package com.jose.crudApp.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document(collection = "ToDo")
public class ToDo {
    @Id
    private int id;
    private String title;
    private String description;
    private LocalDateTime timestamp;
    private Status status = Status.NOT_STARTED;

    public ToDo() {
        this.timestamp = LocalDateTime.now();
    }

    public void updateTimestamp() {
        this.timestamp = LocalDateTime.now();
    }

}
