package com.jose.crudApp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.crudApp.model.ToDo;
import com.jose.crudApp.repository.ToDoRepos;
import com.jose.crudApp.services.DeleteToDoService;
import com.jose.crudApp.services.UpdateTodoService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@AllArgsConstructor
@RequestMapping("/todo")
public class CreateToDo {

    private final ToDoRepos toDoRepos;
    private final DeleteToDoService deleteToDoService;
    private final UpdateTodoService updateTodoService;

    @PostMapping()
    public ResponseEntity<ToDo> createToDo(@RequestBody ToDo toDo) {
        ToDo savedToDo = toDoRepos.save(toDo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedToDo);
    }

    @GetMapping()
    public ResponseEntity<List<ToDo>> getToDos() {
        List<ToDo> toDos = toDoRepos.findAll();
        return ResponseEntity.ok(toDos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDo(@PathVariable int id) {
        System.out.println("---id----");
        System.out.println(id);
        System.out.println("---id----");
        deleteToDoService.deleteToDoById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDo> updateToDo(@PathVariable int id, @RequestBody ToDo toDo) {
        System.out.println("----id---");
        System.out.println(id);
        System.out.println("----id---");
        updateTodoService.updateToDo(id, toDo);
        return ResponseEntity.ok(toDo);
    }
}
