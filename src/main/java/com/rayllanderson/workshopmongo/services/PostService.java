package com.rayllanderson.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rayllanderson.workshopmongo.entities.Post;
import com.rayllanderson.workshopmongo.exceptions.ObjectNotFoundException;
import com.rayllanderson.workshopmongo.repositories.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) throws ObjectNotFoundException {
	Post obj = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	return obj;
    }
    
    public List<Post> findByTitle(String title){
	return repository.findByTitleContainingIgnoreCase(title);
    }

}
