package com.birthday.aisen.service;

import com.birthday.aisen.dto.UserDTO;

public interface IUserService {
    public UserDTO getUserById(String uuid);
}
