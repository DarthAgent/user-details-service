package com.darth.userdetails.controllers;

import com.darth.userdetails.api.dto.UserManageDto;
import com.darth.userdetails.api.logic.UserManageLogic;
import com.darth.userdetails.db.entities.User;
import com.darth.userdetails.services.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manage")
public class UserManageController implements UserManageLogic {

    @Autowired
    private UserManageService userManageService;

    @Override
    @PostMapping
    public User createUser(@RequestBody UserManageDto userManageDTO) {
        return userManageService.createUser(userManageDTO);
    }

    @Override
    @PutMapping(value = "/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UserManageDto userManageDTO) {
        return userManageService.updateUser(id, userManageDTO);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Long id) {
        userManageService.deleteUser(id);
    }
}
