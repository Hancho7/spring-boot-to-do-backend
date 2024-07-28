package com.jose.crudApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jose.crudApp.model.ToDo;

@Repository
public interface ToDoRepos extends MongoRepository<ToDo, Integer > {
    
}
