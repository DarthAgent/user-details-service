package com.darth.userdetails.api.logic;

import com.darth.userdetails.api.dto.UserManageDto;
import com.darth.userdetails.db.entities.User;

public interface UserManageLogic {

    User createUser(UserManageDto userManageDTO);

    User updateUser(Long id, UserManageDto userManageDTO);

    void deleteUser(Long id);
}
