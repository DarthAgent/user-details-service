package com.darth.userdetails.services;

import com.darth.userdetails.api.logic.UserDetailsLogic;
import com.darth.userdetails.db.entities.User;
import com.darth.userdetails.db.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsService implements UserDetailsLogic {

    private final UserRepository userRepository;

    public UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(new User());
    }
}
