package com.rayllanderson.workshopmongo.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rayllanderson.workshopmongo.dtos.UserDTO;
import com.rayllanderson.workshopmongo.entities.User;
import com.rayllanderson.workshopmongo.repositories.UserRepository;
import com.rayllanderson.workshopmongo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> listAll() {
	List<UserDTO> usersDTO = repository.findAll().stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	return ResponseEntity.ok(usersDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
	return ResponseEntity.ok(new UserDTO(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody UserDTO objDto){
	User obj = service.save(service.fromDTO(objDto));
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
	return ResponseEntity.created(uri).build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
	service.deleteById(id);
	return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserDTO objDto){
	User obj = service.fromDTO(objDto);
	obj.setId(id);
	obj = service.update(obj);
	return ResponseEntity.noContent().build();
    }
    
}
