package com.darth.userdetails.controllers;

import com.darth.userdetails.db.entities.User;
import com.darth.userdetails.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/details")
public class UserDetailsController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    public User getAllUsers(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
