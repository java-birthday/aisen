package com.birthday.aisen.controllers.auth;

import com.birthday.aisen.dto.LoginDTO;
import com.birthday.aisen.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/api/auth")
@CrossOrigin()
@Api(tags = "认证")
public class AuthController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "登陆", notes = "认证管理", httpMethod = "POST")
    @RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<LoginDTO> login(@RequestBody Map<String, String> body, HttpSession session) {

        String username = body.get("username");
        String password = body.get("password");

        LoginDTO dto = userService.login(username, password);



        session.setAttribute("userId", dto.getId());
        session.setAttribute("userToken", dto.getToken());

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
