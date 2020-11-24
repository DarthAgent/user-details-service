package com.darth.userdetails.services;

import com.darth.userdetails.db.entities.User;
import com.darth.userdetails.db.repositories.UserRepository;
import com.darth.userdetails.models.CreateUserRequest;
import com.darth.userdetails.models.UpdateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(new User());
    }

    public User createUser(CreateUserRequest createUserRequest) {
        User user = new User();
        user.setName(createUserRequest.getName());

        userRepository.save(user);

        return user;
    }

    public User updateUser(UpdateUserRequest updateUserRequest) {
        Optional<User> oUser = userRepository.findById(updateUserRequest.getId());

        if (oUser.isPresent()) {
            User user = oUser.get();
            user.setName(updateUserRequest.getName());

            userRepository.save(user);

            return user;
        } else {
            return new User();
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
