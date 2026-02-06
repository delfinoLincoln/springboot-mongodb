package com.delfinolincoln.coursemongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.delfinolincoln.coursemongo.dto.AuthorDto;
import com.delfinolincoln.coursemongo.entities.Post;
import com.delfinolincoln.coursemongo.entities.User;
import com.delfinolincoln.coursemongo.repositories.PostRepository;
import com.delfinolincoln.coursemongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();

        User maria = new User(null, "Philippe Coutinho", "coutinho@gmail.com");
        User alex = new User(null, "Andres Gomes", "gomes@gmail.com");
        User bob = new User(null, "Leo Jardim", "jardim@gmail.com"); 

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDto(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDto(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));
        maria.getPost().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
