package com.example.demo.service;


import com.example.demo.Repository.UserRepository;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl {

    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id){
        Optional<User> optionalDav = userRepository.findById(id);
        return optionalDav.orElse(null);
    }


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}
