package com.birthday.aisen.mapper;

import com.birthday.aisen.entity.User;

import java.util.List;

public interface UserMapper {
    User getUserById(String uuid);
    List<User> getUsersByName(String username);
}
