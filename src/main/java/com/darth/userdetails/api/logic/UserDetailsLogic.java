package com.darth.userdetails.api.logic;

import com.darth.userdetails.db.entities.User;

import java.util.List;

public interface UserDetailsLogic {

    List<User> getAllUsers();

    User getUserById(Long id);
}
