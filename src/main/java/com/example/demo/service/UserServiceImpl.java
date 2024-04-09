package com.example.demo.service;


import com.example.demo.DAO.UserDAO;
import com.example.demo.DAO.UserDAOImpl;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO ud = new UserDAOImpl();
    public List<User> getAll() {
        return ud.getAll();
    }

    public User get(long id) {
        return ud.get(id);
    }

    public void create(User user) {
        ud.create(user);
    }

    public void update(User user) {
        ud.update(user);
    }
    public User delete(long id) {
        return ud.delete(id);
    }
}
