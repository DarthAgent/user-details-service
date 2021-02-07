package com.darth.userdetails.services;

import com.darth.userdetails.api.dto.UserManageDto;
import com.darth.userdetails.api.logic.UserManageLogic;
import com.darth.userdetails.db.entities.User;
import com.darth.userdetails.db.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserManageService implements UserManageLogic {

    private final UserRepository userRepository;

    public UserManageService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(UserManageDto userManageDTO) {
        User user = new User();
        user.setName(userManageDTO.getName());

        userRepository.save(user);

        return user;
    }

    @Override
    public User updateUser(Long id, UserManageDto userManageDTO) {
        Optional<User> oUser = userRepository.findById(id);

        if (oUser.isPresent()) {
            User user = oUser.get();
            user.setName(userManageDTO.getName());

            userRepository.save(user);

            return user;
        } else {
            return new User();
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
