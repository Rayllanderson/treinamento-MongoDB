package com.rayllanderson.workshopmongo.configs;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rayllanderson.workshopmongo.entities.Post;
import com.rayllanderson.workshopmongo.entities.User;
import com.rayllanderson.workshopmongo.repositories.PostRepository;
import com.rayllanderson.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PostRepository postRepository;
    
    @Override
    public void run(String... args) throws Exception {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
	
	userRepository.deleteAll();
	postRepository.deleteAll();
	
	User maria = new User(null, "Maria", "maria@gmail.com");
	User joao = new User(null, "João", "Joao@gmail.com");
	User joaoLucas = new User(null, "João Lucas", "joao33232@gmail.com");
	
	Post post1 = new Post(null, sdf.parse("12/02/2021"), "fiuk", "rapai, fiuk bbb2021 xalalalala twitter só tem isso", maria);
	Post post2 = new Post(null, sdf.parse("13/02/2021"), "EAE seus putos!", "ovo viajar amanhã, tmj?", maria);
	
	userRepository.saveAll(Arrays.asList(maria, joao, joaoLucas));
	postRepository.saveAll(Arrays.asList(post1, post2));
	
    }

}
