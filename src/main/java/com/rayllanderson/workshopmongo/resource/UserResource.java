package com.rayllanderson.workshopmongo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rayllanderson.workshopmongo.entities.User;
import com.rayllanderson.workshopmongo.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserRepository repository; 
    
    @GetMapping
    public ResponseEntity<List<User>> listAll(){
	return ResponseEntity.ok(repository.findAll());
    }
}
