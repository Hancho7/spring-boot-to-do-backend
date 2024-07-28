package com.jose.crudApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jose.crudApp.model.ToDo;
import com.jose.crudApp.repository.ToDoRepos;

@Service
public class UpdateTodoService {

    @Autowired
    private ToDoRepos toDoRepos;

    public void updateToDo(int id, ToDo toDo) {
        System.out.println("--------ID-------");
        System.out.println(id);
        System.out.println("--------ID-------");
        
        Optional<ToDo> existingToDo = toDoRepos.findById(id);
        if (existingToDo.isPresent()) {
            ToDo toDoToUpdate = existingToDo.get();
            if (toDo.getTitle() != null) {
                toDoToUpdate.setTitle(toDo.getTitle());
            }
            if (toDo.getDescription() != null) {
                toDoToUpdate.setDescription(toDo.getDescription());
            }
            if (toDo.getStatus() != null) {
                toDoToUpdate.setStatus(toDo.getStatus());
            }
            toDoToUpdate.updateTimestamp(); 
            toDoRepos.save(toDoToUpdate);
        } else {
            System.out.println("No todo found with id: " + toDo.getId());
        }
    }
}
