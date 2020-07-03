package br.com.codenation.controllers;

import br.com.codenation.dto.interfaces.IDTO;
import br.com.codenation.mapper.interfaces.EntityMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.codenation.model.interfaces.IModel;
import br.com.codenation.service.AbstractService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public abstract class AbstractController<MODEL extends IModel, K extends IDTO, ID> {

    private AbstractService<MODEL, ID> service;
    private EntityMapper<MODEL, K> mapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Lista todas os models")
    public List<K> listAll() {
        return mapper.toDTOs(service.findAll());
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Busca um registro no banco pelo id")
    public K getById(@PathVariable ID id){
        return mapper.toDTO(service.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Adiciona um novo registro no banco")
    public K create(@RequestBody K dto){
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Deleta um registro no banco pelo id")
    public void delete(@PathVariable ID id){
         service.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Atualiza um registro no banco pelo id")
    public K update(@PathVariable ID id, @RequestBody K dto){
        MODEL model = mapper.toEntity(dto);
        model.setId(id);
        return mapper.toDTO(service.update(model));
    }

}
