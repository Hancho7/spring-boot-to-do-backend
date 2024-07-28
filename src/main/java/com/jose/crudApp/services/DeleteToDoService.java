package com.jose.crudApp.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jose.crudApp.model.ToDo;
import com.jose.crudApp.repository.ToDoRepos;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DeleteToDoService {

    private final ToDoRepos toDoRepos;

    public void deleteToDoById(int id) {
        Optional<ToDo> todo = toDoRepos.findById(id);
        if (todo.isPresent()) {
            toDoRepos.deleteById(id);
        } else {
            System.out.println("No todo with such id exists");
        }
    }
}
