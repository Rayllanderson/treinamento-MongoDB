package com.rayllanderson.workshopmongo.configs;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rayllanderson.workshopmongo.entities.User;
import com.rayllanderson.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public void run(String... args) throws Exception {
	
	userRepository.deleteAll();
	
	User maria = new User(null, "Maria", "maria@gmail.com");
	User joao = new User(null, "João", "Joao@gmail.com");
	User joaoLucas = new User(null, "João Lucas", "joao33232@gmail.com");
	
	userRepository.saveAll(Arrays.asList(maria, joao, joaoLucas));
	
    }

}