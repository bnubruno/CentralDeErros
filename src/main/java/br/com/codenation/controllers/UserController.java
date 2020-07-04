package br.com.codenation.controllers;

import br.com.codenation.dto.UserDTO;
import br.com.codenation.mapper.UserMapper;
import br.com.codenation.model.User;
import br.com.codenation.repositories.UserRepository;
import br.com.codenation.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@Api(value = "Responsável pelo controle de usuários da aplicação.")
public class UserController extends AbstractController<UserService, UserMapper, UserRepository, User, UserDTO, UUID> {

    @Autowired
    public UserController(UserService service, UserMapper mapper) {
        super(service, mapper);
    }
}
