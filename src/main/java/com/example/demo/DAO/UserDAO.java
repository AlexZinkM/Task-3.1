package com.example.demo.DAO;


import com.example.demo.model.User;

import java.util.List;

public interface UserDAO {
     List<User> getAll();

    User get(long id);

    void create(User user);

    void update(User updatedPerson);

    public User delete(long id);
}
