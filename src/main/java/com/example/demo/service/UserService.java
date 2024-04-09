package com.example.demo.service;


import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User get(long id);

    void create(User user);

    void update(User updatedPerson);

    public User delete(long id);
}
