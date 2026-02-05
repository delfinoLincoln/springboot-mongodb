package com.delfinolincoln.coursemongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.delfinolincoln.coursemongo.entities.User;
import com.delfinolincoln.coursemongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User maria = new User(null, "Philippe Coutinho", "coutinho@gmail.com");
        User alex = new User(null, "Andres Gomes", "gomes@gmail.com");
        User bob = new User(null, "Leo Jardim", "jardim@gmail.com"); 

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
    }
}
