package com.rayllanderson.workshopmongo.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rayllanderson.workshopmongo.entities.User;

@RestController
@RequestMapping("/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> listAll(){
	List<User> users = new ArrayList<>();
	users.add(new User("1", "João", "joao@gmail.com"));
	users.add(new User("4", "Maria", "Maria@gmail.com"));
	users.add(new User("1", "Pedro", "Pedro@gmail.com"));
	return ResponseEntity.ok(users);
    }
}
