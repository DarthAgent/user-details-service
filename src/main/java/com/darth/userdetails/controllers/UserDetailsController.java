package com.darth.userdetails.controllers;

import com.darth.userdetails.api.logic.UserDetailsLogic;
import com.darth.userdetails.db.entities.User;
import com.darth.userdetails.services.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/details")
public class UserDetailsController implements UserDetailsLogic {

    private final UserDetailsService userDetailsService;

    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    @GetMapping(value = "/all")
    public List<User> getAllUsers() {
        return userDetailsService.getAllUsers();
    }

    @Override
    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable Long id) {
        return userDetailsService.getUserById(id);
    }
}
