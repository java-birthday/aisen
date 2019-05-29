package com.birthday.aisen.mapper;

import com.birthday.aisen.entity.User;

import java.util.List;

public interface UserMapper {
    User getUserById(int uid);
    List<User> getUsersByName(String username);
}
