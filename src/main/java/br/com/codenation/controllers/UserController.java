package br.com.codenation.controllers;

import br.com.codenation.dto.UserDTO;
import br.com.codenation.mapper.UserMapper;
import br.com.codenation.model.User;
import br.com.codenation.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@Api(value = "Responsável pelo controle de usuários da aplicação.")
public class UserController extends AbstractController<User, UserDTO, UUID>{

    private UserService userService;
    private UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper){
        super(userService, userMapper);
        this.userService = userService;
        this.userMapper = userMapper;
    }

}
