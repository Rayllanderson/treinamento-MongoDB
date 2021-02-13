package com.rayllanderson.workshopmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rayllanderson.workshopmongo.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
    
    List<Post> findByTitleContainingIgnoreCase(String text);
    
}
