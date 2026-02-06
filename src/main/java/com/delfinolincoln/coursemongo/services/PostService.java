package com.delfinolincoln.coursemongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delfinolincoln.coursemongo.entities.Post;
import com.delfinolincoln.coursemongo.repositories.PostRepository;
import com.delfinolincoln.coursemongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found!")); 
    }

    public List<Post> findByTitle(String title) {
        return postRepository.findByTitleIgnoreCase(title);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        if (maxDate != null) {
            maxDate = new Date(maxDate.getTime() + 24 * 60 * 60  * 1000);
        }
        return postRepository.fullSearch(text, minDate, maxDate);
    }
}