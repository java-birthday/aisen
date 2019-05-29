package com.birthday.aisen.service.impl;

import com.birthday.aisen.entity.User;
import com.birthday.aisen.dto.UserDTO;
import com.birthday.aisen.mapper.UserMapper;
import com.birthday.aisen.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<UserDTO> getUsersByName(String username) {
        List<UserDTO> dtos = new ArrayList<>();
        List<User> entities = userMapper.getUsersByName('%' + username + '%');
        for (User entity : entities) {
            UserDTO dto = new UserDTO();
            BeanUtils.copyProperties(entity, dto);
            dtos.add(dto);
        }
        return dtos;
    }
}
