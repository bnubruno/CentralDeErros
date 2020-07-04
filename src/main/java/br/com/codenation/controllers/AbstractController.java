package br.com.codenation.controllers;

import br.com.codenation.dto.interfaces.DTO;
import br.com.codenation.mapper.interfaces.EntityMapper;
import br.com.codenation.model.interfaces.BaseEntity;
import br.com.codenation.service.AbstractService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
public abstract class AbstractController<S extends AbstractService<R, E, ID>, M extends EntityMapper<E, D>, R extends JpaRepository<E, ID>, E extends BaseEntity, D extends DTO, ID> {

    protected S service;
    protected M mapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Lista todas os models")
    public List<D> listAll() {
        return mapper.toDTOs(service.findAll());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Busca um registro no banco pelo id")
    public D getById(@PathVariable ID id) {
        return mapper.toDTO(service.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Adiciona um novo registro no banco")
    public D create(@RequestBody D dto) {
        return mapper.toDTO(service.save(mapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Deleta um registro no banco pelo id")
    public void delete(@PathVariable ID id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Atualiza um registro no banco pelo id")
    public D update(@PathVariable ID id, @RequestBody D dto) {
        E model = mapper.toEntity(dto);
        model.setId(id);
        return mapper.toDTO(service.update(model));
    }

}
