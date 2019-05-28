package com.birthday.aisen.service;

import com.birthday.aisen.entity.User;
import com.birthday.aisen.dto.UserDTO;
import com.birthday.aisen.mapper.UserMapper;
import com.birthday.aisen.service.impl.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public UserDTO getUserById(String uuid) {
        UserDTO dto = new UserDTO();
        User entity = userMapper.getUserById(uuid);
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
