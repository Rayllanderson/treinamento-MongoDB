package com.rayllanderson.workshopmongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rayllanderson.workshopmongo.dtos.UserDTO;
import com.rayllanderson.workshopmongo.entities.User;
import com.rayllanderson.workshopmongo.exceptions.ObjectNotFoundException;
import com.rayllanderson.workshopmongo.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository; 
    
    public User save (User obj) {
	return repository.save(obj);
    }
    
    public User findById(String id) {
	User user = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto User não encontrado"));
	return user;
    }
    
    public User fromDTO(UserDTO obj) {
	return new User(obj.getId(), obj.getNome(), obj.getEmail());
    }
    
}
