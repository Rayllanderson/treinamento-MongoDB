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
    
    public User findById(String id) throws ObjectNotFoundException{
	User obj = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	return obj;
    }
    
    public User fromDTO(UserDTO obj) {
	return new User(obj.getId(), obj.getNome(), obj.getEmail());
    }

    public void deleteById(String id) throws ObjectNotFoundException{
	findById(id);
	repository.deleteById(id);
    }
    
    public User update(User objFromBody) {
	User objFromDataBase = findById(objFromBody.getId());
	updateData(objFromDataBase, objFromBody);
	return repository.save(objFromDataBase);
    }

    private void updateData(User objFromDataBase, User objFromBody) {
	objFromDataBase.setNome(objFromBody.getNome());
	objFromDataBase.setEmail(objFromBody.getEmail());
    }
    
}
