package com.rayllanderson.workshopmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.rayllanderson.workshopmongo.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
    
    /* 
     * Mais sobre buscas com MongoDB
     *
     * https://docs.mongodb.com/manual/reference/operator/query/regex/
     */
    
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> findPostsByTitle(String title);
    
    List<Post> findByTitleContainingIgnoreCase(String title);
    
}
