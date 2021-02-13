package com.rayllanderson.workshopmongo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rayllanderson.workshopmongo.entities.Post;
import com.rayllanderson.workshopmongo.repositories.PostRepository;
import com.rayllanderson.workshopmongo.resource.util.URL;
import com.rayllanderson.workshopmongo.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostResource {

    @SuppressWarnings("unused")
    @Autowired
    private PostRepository repository;

    @Autowired
    private PostService service;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
	return ResponseEntity.ok(service.findById(id));
    }
    
    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue = "") String text) {
	return ResponseEntity.ok(service.findByTitle(URL.decodeParam(text)));
    }
    
    
}
