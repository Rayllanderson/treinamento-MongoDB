package com.rayllanderson.workshopmongo.configs;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rayllanderson.workshopmongo.dtos.AuthorDTO;
import com.rayllanderson.workshopmongo.dtos.CommentDTO;
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
	
	userRepository.saveAll(Arrays.asList(maria, joao, joaoLucas));
	
	Post post1 = new Post(null, sdf.parse("12/02/2021"), "fiuk", "rapai, fiuk bbb2021 xalalalala twitter só tem isso", new AuthorDTO(maria));
	Post post2 = new Post(null, sdf.parse("13/02/2021"), "EAE seus putos!", "ovo viajar amanhã, tmj?", new AuthorDTO(maria));
	
	CommentDTO c1 = new CommentDTO("JKKK pois é, fiuk todo dia na minha timeline também", sdf.parse("12/02/2021"), new AuthorDTO(joao));
	CommentDTO c2 = new CommentDTO("calados, fiuk ja ganhou! #teamfiuk", sdf.parse("12/02/2021"), new AuthorDTO(joaoLucas));
	CommentDTO c3 = new CommentDTO("xiu, chega desse papo, seus putos", sdf.parse("12/02/2021"), new AuthorDTO(maria));
	CommentDTO c4 = new CommentDTO("nas horas, boa viagem!", sdf.parse("13/02/2021"), new AuthorDTO(joao));
	CommentDTO c5 = new CommentDTO("obrigada", sdf.parse("13/02/2021"), new AuthorDTO(maria));
	
	post1.getComments().addAll(Arrays.asList(c1, c2, c3));
	post2.getComments().addAll(Arrays.asList(c4, c5));
	
	postRepository.saveAll(Arrays.asList(post1, post2));
	
	maria.getPosts().addAll(Arrays.asList(post1, post2));
	userRepository.save(maria);
	
    }

}
