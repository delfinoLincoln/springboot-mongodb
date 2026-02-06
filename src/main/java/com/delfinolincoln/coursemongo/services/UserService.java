package com.delfinolincoln.coursemongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delfinolincoln.coursemongo.dto.UserDto;
import com.delfinolincoln.coursemongo.entities.User;
import com.delfinolincoln.coursemongo.repositories.UserRepository;
import com.delfinolincoln.coursemongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found!"));
    }

    public User insert(User user) {
        return userRepository.insert(user);
    }

    public void deleteById(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User updateUser(User user) {
        User newUser = userRepository.findById(user.getId())
        .orElseThrow(() -> new ObjectNotFoundException(
            "User not found with id: " + user.getId()
        ));
        updateData(newUser, user);
        return userRepository.save(newUser);
    }

    public void updateData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    } 

    public User fromDto(UserDto userDto) {
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
    }
}
