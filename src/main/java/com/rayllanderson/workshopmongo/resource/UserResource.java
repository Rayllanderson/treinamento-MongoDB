package com.rayllanderson.workshopmongo.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rayllanderson.workshopmongo.dtos.UserDTO;
import com.rayllanderson.workshopmongo.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserRepository repository; 
    
    @GetMapping
    public ResponseEntity<List<UserDTO>> listAll(){
	List <UserDTO> usersDTO = repository.findAll().stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	return ResponseEntity.ok(usersDTO);
    }
}
