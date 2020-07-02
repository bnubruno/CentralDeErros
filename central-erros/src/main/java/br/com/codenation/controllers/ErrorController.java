package br.com.codenation.controllers;

import br.com.codenation.dto.LogDTO;
import br.com.codenation.mapper.LogMapper;
import br.com.codenation.model.Error;
import br.com.codenation.service.ErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/log")
public class ErrorController extends AbstractController<Error, LogDTO, UUID>{

    private ErrorService errorService;
    private LogMapper logMapper;

    @Autowired
    public ErrorController(ErrorService errorService, LogMapper logMapper){
        super(errorService, logMapper);
        this.errorService = errorService;
        this.logMapper = logMapper;
    }

    @GetMapping("/filter")
    @ResponseStatus(HttpStatus.OK)
    public List<Error> listFilters(@RequestParam(required = false) Map<Class<?>, Class<?>> params,
    		@RequestParam(
    				value = "page",
    				required = false,
    				defaultValue = "0") int page,
    		@RequestParam(
    				value = "size",
    				required = false,
    				defaultValue = "5") int size,
    		@RequestParam(value = "orderBy",
    				defaultValue = "id") String orderBy,
    		@RequestParam (
    				value = "direction",
    				defaultValue = "asc") String direction) {
    	PageRequest pageRequest = PageRequest.of(page, size, Direction.fromString(direction), orderBy);
    	return errorService.findWithFilters(params, pageRequest);
    }
}
