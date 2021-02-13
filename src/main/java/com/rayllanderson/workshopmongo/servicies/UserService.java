package com.rayllanderson.workshopmongo.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rayllanderson.workshopmongo.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository; 
    
    
}
