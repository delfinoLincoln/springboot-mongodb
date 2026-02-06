package com.delfinolincoln.coursemongo.dto;

import com.delfinolincoln.coursemongo.entities.User;

public class AuthorDto {
    private String name;
    private String id;

    public AuthorDto() {
    }

    public AuthorDto(User user) {
        id = user.getId();
		name = user.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}