package com.birthday.aisen.service;

import com.birthday.aisen.dto.UserDTO;

import java.util.List;

public interface IUserService {
    public UserDTO getUserById(String uuid);

    public List<UserDTO> getUsersByName(String username);
}
