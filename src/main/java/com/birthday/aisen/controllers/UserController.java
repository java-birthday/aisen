package com.birthday.aisen.controllers;

import com.birthday.aisen.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.birthday.aisen.dto.UserDTO;

import java.util.List;

@Controller
@RequestMapping("/api/user")
@CrossOrigin()
@Api(tags= "用户管理->获取用户信息")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "获取用户信息", notes = "用户管理", httpMethod = "GET")
    @RequestMapping(value = "{uuid}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<UserDTO> info(@PathVariable String uuid) {
        UserDTO info = userService.getUserById(uuid);
        return new ResponseEntity<>(info, HttpStatus.OK);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<UserDTO>> searchUser(String q) {
        List<UserDTO> info = userService.getUsersByName(q);
        return new ResponseEntity<>(info, HttpStatus.OK);
    }
}
