package br.com.codenation.controllers;

import br.com.codenation.dto.ApplicationDTO;
import br.com.codenation.mapper.ApplicationMapper;
import br.com.codenation.model.Application;
import br.com.codenation.repositories.ApplicationRepository;
import br.com.codenation.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/application")
public class ApplicationController extends AbstractController<ApplicationService, ApplicationMapper, ApplicationRepository, Application, ApplicationDTO, UUID> {

    @Autowired
    public ApplicationController(ApplicationService service, ApplicationMapper mapper) {
        super(service, mapper);
    }
}
