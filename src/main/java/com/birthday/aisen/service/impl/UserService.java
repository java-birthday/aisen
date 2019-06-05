package com.birthday.aisen.service.impl;

import com.birthday.aisen.dto.LoginDTO;
import com.birthday.aisen.entity.User;
import com.birthday.aisen.dto.UserDTO;
import com.birthday.aisen.mapper.UserMapper;
import com.birthday.aisen.service.IUserService;
import com.birthday.aisen.utils.Token;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class UserService implements IUserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public UserDTO getUserById(long uid) {
        UserDTO dto = new UserDTO();
        User entity = userMapper.getUserById(uid);

        logger.info(entity.toString());
        // test redis
        redisTemplate.opsForValue().set(String.valueOf(entity.getId()), entity.getUsername());
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

    public LoginDTO login(String username, String password) {
        LoginDTO dto = new LoginDTO();
        User entity = userMapper.getUserByName(username);

        if (entity == null) {
            // todo
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        } else {
            // check password
            if (!entity.getPassword().equals(DigestUtils.md5Hex(password).toUpperCase())) {
                // todo
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
            }
        }

        Token token = new Token();
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", entity.getId());

        dto.setId(entity.getId());
        dto.setToken(token.generate(map));

        return dto;
    }
}
